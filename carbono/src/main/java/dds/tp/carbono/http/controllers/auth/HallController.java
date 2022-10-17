package dds.tp.carbono.http.controllers.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.HallAsigAgenteDTO;
import dds.tp.carbono.http.dto.auth.HallDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.agenteSectorial.AsignadorDeAgentesSectoriales;
import dds.tp.carbono.services.auth.HallMiembroService;
import dds.tp.carbono.services.auth.HallOrganizacionService;
import dds.tp.carbono.services.auth.SolicitadorDeVinculacionService;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import spark.Spark;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;



public class HallController extends Controller {

        private HallMiembroService serviceMiembro;
        private HallOrganizacionService serviceOrganizacion; 
        private SolicitadorDeVinculacionService serviceSolicitudVinculacion;
        private AsignadorDeAgentesSectoriales asignadorAgenteSectorial;

        public HallController(HallMiembroService serviceMiembro,
                            HallOrganizacionService serviceOrganizacion,
                             SolicitadorDeVinculacionService serviceSolicitudVinculacion,
                             AsignadorDeAgentesSectoriales asignadorAgenteSectorial ) {
            this.serviceMiembro = serviceMiembro;
            this.serviceOrganizacion = serviceOrganizacion;
            this.serviceSolicitudVinculacion = serviceSolicitudVinculacion;
            this.asignadorAgenteSectorial = asignadorAgenteSectorial;
        }
    
      
    
        @Override
        public void routes(TemplateEngine engine) {
            
            Spark.post(path(Uri.HALL), (rq, rs) -> this.hall(rq, rs));
        }


    
        private String hall(Request rq, Response rs) throws HttpException {
    
            HallDTO input = getBody(rq, HallDTO.class, null);
            HallAsigAgenteDTO inputAgSec = getBody(rq, HallAsigAgenteDTO.class, null);
    
    
            try {
                
               // Usuario usuario = service.register(input.getUsername(), input.getPassword(), input.getRol());

                switch(input.getRol()){

                    // ROL MIEMBRO
                    case "MIEMBRO": 
                            Miembro miembro = serviceMiembro.register(input.getNombre(),
                                                                    input.getApellido(), 
                                                                    input.getTipoDocumento(),
                                                                    input.getNroDocumento());

                            Sector sector = new Sector(Integer.parseInt(input.getIdSector()));
                                                            
                            if (input.getFlagSolicitud() == "1"){
                                serviceSolicitudVinculacion.solicitarVinculacionInicialPorHall(sector ,miembro);
                            }
                            return json(goodAnswer());

                    case "ORGANIZACION":

                                serviceOrganizacion.register(input.getRazonSocial(), input.getClasficacion(),
                                                         input.getCalle(),input.getAltura(), input.getLocalidad(),input.getMunicipio(),
                                                         input.getProvincia(),input.getPais(), input.getTipoOrganizacion());
                                
                                return json(goodAnswer());      
                    case "AGENTE_SECTORIAL":

                            Usuario user= new Usuario(Integer.parseInt(inputAgSec.getId()),inputAgSec.getUsername());
                
                            if(inputAgSec.getIdMunicipio() == null){
                            Provincia prov = new Provincia();
                            prov.setId(Integer.parseInt(inputAgSec.getIdProvincia()));
                            asignadorAgenteSectorial.asignar(prov, user);}
                            else{
                            Municipio muni =new Municipio(Integer.parseInt(inputAgSec.getIdMunicipio()));
                            asignadorAgenteSectorial.asignar(muni, user);}

                            return json(goodAnswer()); 
                    }

            }
            
            catch (Exception ex) {
                    System.out.println("No se pudo Asignar el Agente Sectorial");     
            }
            return json(goodAnswer());
    
        } 

             
    }



    

