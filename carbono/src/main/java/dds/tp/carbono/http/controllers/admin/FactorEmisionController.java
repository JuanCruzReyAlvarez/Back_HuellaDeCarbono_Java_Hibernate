package dds.tp.carbono.http.controllers.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jetty.http.HttpStatus;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.http.controllers.AuthorizationMiddleware;
import dds.tp.carbono.http.dto.ErrorDTO;
import dds.tp.carbono.http.dto.admin.FactorEmisionDTO;
import dds.tp.carbono.http.dto.validators.FactorEmisionDTOValidator;
import dds.tp.carbono.http.exceptions.BadResquestException;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.huella.EditorFactoresEmision;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class FactorEmisionController extends AuthorizationMiddleware {

    private static final String VIEW_FILE = "admin/factores.emision.html";
    private EditorFactoresEmision editorFE;

    public FactorEmisionController() { 
        super(Rol.ADMINISTRADOR);
        this.editorFE = new EditorFactoresEmision(); 
    }    
    
    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.ADMIN_FACTOR_EMISION), (rq, rs) -> this.view(VIEW_FILE, getList(getViewData())), engine);
        Spark.post(path(Uri.ADMIN_FACTOR_EMISION), (rq, rs) -> this.createOrUpdate(rq, rs), engine);
    }

    private ModelAndView createOrUpdate(Request rq, Response rs) throws HttpException {
        Map<String, Object> data = getViewData();
        
        try {
            Map<String, String> input = formFields(rq);
            FactorEmisionDTO feDTO = validateInput(parseFEfrom(input), new FactorEmisionDTOValidator());
            editorFE.guardar(feDTO.toFactorEmision());
            data.put("success", "Factor de Emision guardado correctamente");
        } catch (BadResquestException badRequest) {
            data.put("errors", badRequest.getErrors());
            rs.status(HttpStatus.BAD_REQUEST_400);
        } catch (Exception error) {
            data.put("errors", Arrays.asList(new ErrorDTO("Error", error.getMessage())));
            rs.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
        }
           
        data = getList(data);
        return this.view(VIEW_FILE, data);
    }

    private Map<String, Object> getList(Map<String, Object> data) {
        List<FactorEmisionDTO> list = this.editorFE.obtenerTodos()
                            .stream()
                            .map(fe -> new FactorEmisionDTO(fe))
                            .collect(Collectors.toList());

        data.put("showFactoresEmision", list.size() > 0);
        data.put("factoresEmision", list);
        return data;
    }

    private FactorEmisionDTO parseFEfrom(Map<String, String> input) {
        try {
            return new FactorEmisionDTO(
                input.get("actividad"), 
                input.get("tipoConsumo"), 
                input.get("unidad"), 
                input.get("valor"));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private Map<String, Object> getViewData() {
        return new HashMap<String, Object>() {{
            put("actividades", Stream.of(TipoActividad.values()).map(Enum::toString).collect(Collectors.toList())); 
            put("tiposConsumo", Stream.of(TipoDeConsumo.values()).map(Enum::name).collect(Collectors.toList()));
            put("unidades", Stream.of(UnidadFE.values()).map(Enum::toString).collect(Collectors.toList()));
        }};
    }
}
