package dds.tp.carbono.http.controllers.auth;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.http.controllers.Controller;
//import dds.tp.carbono.http.dto.auth.HallAsigAgenteDTO;


import dds.tp.carbono.http.dto.auth.HallMiembroDTO;
import dds.tp.carbono.http.dto.auth.HallOrgDTO;
import dds.tp.carbono.http.dto.auth.RolDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.agenteSectorial.AsignadorDeAgentesSectoriales;
import dds.tp.carbono.services.auth.HallMiembroService;
import dds.tp.carbono.services.auth.HallOrganizacionService;
import dds.tp.carbono.services.auth.SolicitadorDeVinculacionService;
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
            //Spark.get(path(Uri.HALL), (rq, rs) -> this.getRol(rq, rs));
            Spark.post(path(Uri.HALL), (rq, rs) -> this.hall(rq, rs));
        }

        /* 
        private  getRol(Request rq, Response rs) {
            
            RolDTO input = getBody(rq, RolDTO.class, null);

            
        }
        */

        private String hall(Request rq, Response rs) throws HttpException {
            
            RolDTO inputRol = getBody(rq, RolDTO.class, null);
           
            
            try {
                
               // Usuario usuario = service.register(input.getUsername(), input.getPassword(), input.getRol());

                switch(inputRol.getRol()){
                     

                  
                    case "MIEMBRO": 
                            HallMiembroDTO inputM = getBody(rq, HallMiembroDTO.class, null);

                            Miembro miembro = serviceMiembro.register(inputM.getNombre(),
                                                                    inputM.getApellido(), 
                                                                    inputM.getTipoDocumento(),
                                                                    inputM.getNroDocumento(), inputM.getUserId()
                                                                    );
                                                                    //org sector flag solicitud 

                            Sector sector = new Sector(Integer.parseInt(inputM.getIdSector()));
                                                            
                            if (inputM.getFlagSolicitud() == "1"){
                                serviceSolicitudVinculacion.solicitarVinculacionInicialPorHall(sector ,miembro);
                            }
                            return json(goodAnswer());
                  
                    case "ORGANIZACION":
                                
                                HallOrgDTO input = getBody(rq, HallOrgDTO.class, null);
                                System.out.println("1");
                                System.out.println(input.getUserId());
                                serviceOrganizacion.register(input.getRazonSocial(), input.getClasificacion(),
                                                         input.getCalle(),input.getAltura(), input.getIdlocalidad(),input.getIdMunicipio(),
                                                         input.getIdProvincia(), input.getTipoOrganizacion(), input.getUserId() );
                                
                                return json(goodAnswer());      
                    case "AGENTE_SECTORIAL":
                          /*        
                            
                            
                            Usuario user= new Usuario(Integer.parseInt(inputAgSec.getId()),inputAgSec.getUsername());
                            
                            if(inputAgSec.getIdMunicipio() == null){
                            Provincia prov = new Provincia();
                            prov.setId(Integer.parseInt(inputAgSec.getIdProvincia()));
                            asignadorAgenteSectorial.asignar(prov, user);}
                            else{
                            Municipio muni =new Municipio(Integer.parseInt(inputAgSec.getIdMunicipio()));
                            asignadorAgenteSectorial.asignar(muni, user);}

                            return json(goodAnswer()); 
                             */
                    }    

            }
            
            catch (Exception ex) {
                    System.out.println("No se pudo Asignar el Agente Sectorial");     
            }
            return json(goodAnswer());
    
        } 

             
    }



    

