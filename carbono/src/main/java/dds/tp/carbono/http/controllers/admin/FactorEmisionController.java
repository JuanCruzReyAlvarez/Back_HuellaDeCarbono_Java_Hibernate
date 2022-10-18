package dds.tp.carbono.http.controllers.admin;


import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.http.controllers.AuthorizationMiddleware;
import dds.tp.carbono.http.dto.admin.FactorEmisionDTO;
import dds.tp.carbono.http.dto.validators.FactorEmisionDTOValidator;
import dds.tp.carbono.http.exceptions.BadResquestException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.huella.EditorFactoresEmision;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class FactorEmisionController extends AuthorizationMiddleware {

    
    private EditorFactoresEmision editorFE;

    public FactorEmisionController() { 
        super(Rol.ADMINISTRADOR);
        this.editorFE = new EditorFactoresEmision(); 
    }    
    
    @Override
    public void routes(TemplateEngine engine) {
        Spark.post(path(Uri.ADMIN_FACTOR_EMISION), (rq, rs) -> this.getFe(rq, rs));
        Spark.get(path(Uri.ADMIN_FACTOR_EMISION), (rq, rs) -> this.createOrUpdate(rq, rs));
        
    }

    private Object getFe(Request rq, Response rs) throws Exception {

        try{
            List<FactorEmision> fes = editorFE.getAll();            
            return json(fes); 
        }catch(Exception exc){
            throw new Exception("In catch Exception geting Organizaciones was fail: ");
        } 

    }

    private String createOrUpdate(Request rq, Response rs) throws Exception {
       
        FactorEmisionDTO input = getBody(rq,FactorEmisionDTO.class, new FactorEmisionDTOValidator());

        try {
            
            FactorEmision fe = set(input.getTipoActividad(), input.getTipoConsumo(), input.getUnidad(), input.getValor(), input.getID());
            editorFE.guardar(fe);

            return json(goodAnswer());
            
        } catch (BadResquestException badRequest) {
            
            rs.status(HttpStatus.BAD_REQUEST_400);
                  
       
        return json(goodAnswer());
        }
    }





    private FactorEmision set(String tipoActividad, String tipoConsumo, String unidad, String valor, String id) {
        FactorEmision fe = new FactorEmision();

        fe.setId(Integer.parseInt(id));
        fe.setValor(Double.parseDouble(valor));
        fe.setUnidad(UnidadFE.valueOf(unidad.toUpperCase()));
        fe.setTipoActividad(TipoActividad.valueOf(tipoActividad.toUpperCase()));
        fe.setTipoDeConsumo(TipoDeConsumo.valueOf(tipoConsumo.toUpperCase()));

        return fe;
    }
}

    
   