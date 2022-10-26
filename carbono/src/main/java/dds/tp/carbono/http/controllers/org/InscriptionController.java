package dds.tp.carbono.http.controllers.org;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.FormulariosInscripcionOrgDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.huella.calculador.org.InscriptionService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class InscriptionController extends Controller{
    
    private InscriptionService service;

      public InscriptionController( InscriptionService service ) { 
        this.service = service;
    }

    @Override
    public void routes() {
        Spark.post(path(Uri.SOL_MIEMBRO), (rq, rs) -> this.makeRequest(rq, rs));
    }

    private String makeRequest(Request rq, Response rs) throws HttpException {
        try{
                FormulariosInscripcionOrgDTO input = getBody(rq, FormulariosInscripcionOrgDTO.class, null);
                service.agregar(Integer.parseInt(input.getIdMiembro()), Integer.parseInt(input.getIdSector()));
                return json(goodAnswer()); 
            }catch(Exception exc){
                System.out.println("In catch Exception while inscription new solicitud ");
            } 
        return null;
    }

}
