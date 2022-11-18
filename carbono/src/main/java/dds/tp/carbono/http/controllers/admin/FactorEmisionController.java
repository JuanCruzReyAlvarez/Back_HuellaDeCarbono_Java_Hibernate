
package dds.tp.carbono.http.controllers.admin;


import java.util.List;

import org.eclipse.jetty.http.HttpStatus;


import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.admin.FactorEmisionDTO;
import dds.tp.carbono.http.dto.validators.FactorEmisionDTOValidator;
import dds.tp.carbono.http.exceptions.BadResquestException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.huella.EditorFactoresEmision;
import spark.Request;
import spark.Response;
import spark.Spark;

public class FactorEmisionController extends Controller {

    
    private EditorFactoresEmision editorFE;

    public FactorEmisionController() { 
        this.editorFE = new EditorFactoresEmision(); 
    }    
    
    @Override
    public void routes() {
        Spark.post(path(Uri.ADMIN_GET_FACTOR_EMISION), (rq, rs) -> this.getFe(rq, rs));
        Spark.post(path(Uri.ADMIN_FACTOR_EMISION), (rq, rs) -> this.createOrUpdate(rq, rs));
        
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

            System.out.println(input.getTipo_de_actividad());
            System.out.println(input.getTipo_de_consumo());
            System.out.println(input.getUnidad());
            System.out.println(input.getValor());
            
            FactorEmision fe = set(input.getTipo_de_actividad(), input.getTipo_de_consumo(), input.getUnidad(), input.getValor());
            editorFE.guardar(fe);
            return json(goodAnswer());

        } catch (BadResquestException badRequest) {  
            rs.status(HttpStatus.BAD_REQUEST_400);
            
        return json(goodAnswer());
        }
    }





    private FactorEmision set(String tipoActividad, String tipoConsumo, String unidad, String valor) {
        FactorEmision fe = new FactorEmision();

        fe.setValor(Double.parseDouble(valor));
        fe.setUnidad(UnidadFE.valueOfStr(unidad));
        fe.setTipoActividad(TipoActividad.valueOf(tipoActividad));
        fe.setTipoDeConsumo(TipoDeConsumo.valueOf(tipoConsumo));

        return fe;
    }
}

 
    
   