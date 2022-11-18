package dds.tp.carbono.http.controllers.org;



import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.SolicitudDTOShower;
import dds.tp.carbono.http.dto.org.RequestDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.organizacion.RequestService;
import dds.tp.carbono.services.organizacion.SectorService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class RequestController extends Controller{
    
    private RequestService service;

      public RequestController( RequestService service ) { 
        this.service = service;
    }

    @Override
    public void routes() {
      
        Spark.get(path(Uri.REQUEST), (rq, rs) -> this.getRequest(rq, rs));
        Spark.post(path(Uri.MOD_REQUEST), (rq, rs) -> this.modRequest(rq, rs));
        Spark.post(path(Uri.CREATE_REQUEST), (rq, rs) -> this.createRequest(rq, rs));
    }


    private String  getRequest(Request rq, Response rs) throws HttpException {
        try{
            List<SolicitudDTOShower> listaDTO = new ArrayList<SolicitudDTOShower>();
            System.out.println("ANTES DE GET ALLLLLLLLLLL");
            List<SolicitudVinculacion> solicitudes = service.getAll(); 
            System.out.println("DESPUES DEL GET ALLLLLLLLLL");

            
            for (SolicitudVinculacion sol:solicitudes )
            {
                SolicitudDTOShower obj= new SolicitudDTOShower();
                           
                obj.setNombre(sol.getMiembro().getNombre());
               
                obj.setApellido(sol.getMiembro().getApellido());
                
                obj.setNroDocumento(sol.getMiembro().getNroDocumento());
                
                obj.setSector(sol.getSector().getNombre());
                
                obj.setIdReq(String.valueOf(sol.getId()));
                //obj.setIdReq(Integer.parse(sol).getId());
                obj.setEstado(matchStringsEnum(sol.getEstado()));
                
                listaDTO.add(obj);
            }
            
            System.out.println("Hola2");

            return json(listaDTO); 

            }catch(Exception exc){
                System.out.println("In catch Exception geting Request was fail: ");
            } 
        return null;
    }

    private String  createRequest(Request rq, Response rs) throws HttpException {
        try{

            System.out.println("HOLA COMO ESTAS JAJAJA");

            SolicitudDTOShower input = getBody(rq, SolicitudDTOShower.class, null);

            MiembroService serviceMiembro = new MiembroService();
            SectorService serviceSector = new SectorService();

            System.out.println("HOLA COMO ESTAS JAJAJA");
            System.out.println(Integer.parseInt(input.getUserId()));
            Miembro miembro = serviceMiembro.getByUserId(Integer.parseInt(input.getUserId()));
            System.out.println("HOLA COMO ESTAS JAJAJA");
            System.out.println(Integer.parseInt(input.getIdSector()));
            Sector sector = serviceSector.getById(Integer.parseInt(input.getIdSector()));
            System.out.println("HOLA COMO ESTAS JAJAJA");

             
            SolicitudVinculacion solicitud = new SolicitudVinculacion();
            solicitud.setEstado(EstadoSolicitudVinculacion.PENDIENTE); 
            solicitud.setMiembro(miembro);
            solicitud.setSector(sector);

            service.save(solicitud);

            return json(goodAnswer()); 

            }catch(Exception exc){
                System.out.println("In catch Exception geting Request was fail: ");
            } 
        return null;
    }

    


    private String  modRequest(Request rq, Response rs) throws HttpException {
        try{
                RequestDTO input = getBody(rq, RequestDTO.class, null);
                SolicitudVinculacion solicitud = new SolicitudVinculacion();
                solicitud = service.getById(Integer.parseInt(input.getIdSolicitud())); 
                System.out.println(":antes de entrar al sitch");
                System.out.println(input.getEstado());
                switch(input.getEstado()){

                    // Para aceptaar
                    case "ACEPTAR": 
                            System.out.println("Entro al switch");
                            System.out.println(solicitud.getEstado());  
                            solicitud.setEstado(EstadoSolicitudVinculacion.ACEPTADO);
                            System.out.println(solicitud.getEstado()); 
                            break; 
                    case  "RECHAZAR":        
                    solicitud.setEstado(EstadoSolicitudVinculacion.RECHAZADO);
                            break;
                }
                
            System.out.println(solicitud.getEstado());
        
            System.out.println(solicitud.getMiembro().getId());
            
            service.repository.update(solicitud); 
            return(json(goodAnswer()));

            }
            catch(Exception exc){
                System.out.println("In catch Exception modificado requestis was fail: ");
            }  
            return null;
    }

    private String matchStringsEnum(EstadoSolicitudVinculacion estado){
        switch(estado){
            case ACEPTADO:
                return "ACEPTADO";
            case RECHAZADO:
                return "RECHAZADO";
            case PENDIENTE:
                return "PENDIENTE";
            default:
            return "Error switcheando estados";
        }
    }

}


