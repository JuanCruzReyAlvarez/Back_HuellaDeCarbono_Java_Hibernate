package dds.tp.carbono.http.controllers.org;



import java.util.List;

import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.RequestDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.RequestService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class RequestController extends Controller{
    
    private RequestService service;

      public RequestController( RequestService service ) { 
        this.service = service;
    }

    @Override
    public void routes(TemplateEngine engine) {
      
        Spark.get(path(Uri.REQUEST), (rq, rs) -> this.getRequest(rq, rs));
        Spark.post(path(Uri.MOD_REQUEST), (rq, rs) -> this.modRequest(rq, rs));
    }

    private String  getRequest(Request rq, Response rs) throws HttpException {
        try{
                List<SolicitudVinculacion> solicitudes = service.getAll();            
                return json(solicitudes); 
            }catch(Exception exc){
                System.out.println("In catch Exception geting Request was fail: ");
            } 
        return null;
    }

    private String  modRequest(Request rq, Response rs) throws HttpException {
        try{
                RequestDTO input = getBody(rq, RequestDTO.class, null);
                SolicitudVinculacion solicitud = service.getById(Integer.parseInt(input.getIdSolicitud())); 
                switch(input.getEstado()){

                    // Para aceptaar
                    case "ACEPTAR": 
                solicitud.setEstado(EstadoSolicitudVinculacion.ACEPTADO);  
                    case  "RECHAZAR":        
                solicitud.setEstado(EstadoSolicitudVinculacion.RECHAZADO);
                
                service.repository.guardar(solicitud); //Deberia sobreescribir
            return(json(goodAnswer()));

            }
            }catch(Exception exc){
                System.out.println("In catch Exception modificado requestis was fail: ");
            }  
            return null;
    }

}
