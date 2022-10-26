package dds.tp.carbono.http.controllers.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.http.controllers.Controller;
//import dds.tp.carbono.http.dto.auth.HallAsigAgenteDTO;
import dds.tp.carbono.http.dto.auth.HallAgenteDTO;
import dds.tp.carbono.http.dto.auth.HallMiembroDTO;
import dds.tp.carbono.http.dto.auth.HallOrgDTO;
import dds.tp.carbono.http.dto.auth.RolDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.agenteSectorial.AsignadorDeAgentesSectoriales;
import dds.tp.carbono.services.auth.HallMiembroService;
import dds.tp.carbono.services.auth.HallOrganizacionService;
import dds.tp.carbono.services.auth.SolicitadorDeVinculacionService;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.MunicipioService;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import dds.tp.carbono.services.organizacion.SectorService;
import spark.Spark;
import spark.Request;
import spark.Response;



public class HallController extends Controller {

        private HallMiembroService serviceMiembro;
        private HallOrganizacionService serviceOrganizacion; 
        private SolicitadorDeVinculacionService serviceSolicitudVinculacion;
        private AsignadorDeAgentesSectoriales asignadorAgenteSectorial;
        private MunicipioService municipioService;
        private ProvinciaService provinciaService;
        private SectorService sectorService;
       

        public HallController(HallMiembroService serviceMiembro,
                            HallOrganizacionService serviceOrganizacion,
                             SolicitadorDeVinculacionService serviceSolicitudVinculacion,
                             AsignadorDeAgentesSectoriales asignadorAgenteSectorial,
                             MunicipioService municipioService,
                             ProvinciaService provinciaService,
                             SectorService sectorService) {
            this.serviceMiembro = serviceMiembro;
            this.serviceOrganizacion = serviceOrganizacion;
            this.serviceSolicitudVinculacion = serviceSolicitudVinculacion;
            this.asignadorAgenteSectorial = asignadorAgenteSectorial;
            this.municipioService = municipioService;
            this.provinciaService = provinciaService;
            this.sectorService = sectorService;
        }
    
      
    
        @Override
        public void routes() {
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

                            //Sector sector = new Sector(Integer.parseInt(inputM.getIdSector()));
                            
                            Sector sector = sectorService.getById(Integer.parseInt(inputM.getIdSector()));
                            
                            if ((inputM.getFlagSolicitud()).equals("1")){
                              
                                serviceSolicitudVinculacion.solicitarVinculacionInicialPorHall(sector ,miembro);
                            }
                            return json(goodAnswer());
                  
                    case "ORGANIZACION":
                                
                                HallOrgDTO input = getBody(rq, HallOrgDTO.class, null);
                               
                                System.out.println(input.getUserId());
                                serviceOrganizacion.register(input.getRazonSocial(), input.getClasificacion(),
                                                         input.getCalle(),input.getAltura(), input.getIdlocalidad(),input.getIdMunicipio(),
                                                         input.getIdProvincia(), input.getTipoOrganizacion(), input.getUserId() );
                                
                                return json(goodAnswer());      
                    case "AGENTE_SECTORIAL":
                                
                                HallAgenteDTO inputA = getBody(rq, HallAgenteDTO.class, null);
                                Usuario usuario = new Usuario(Integer.parseInt(inputA.getUserId()));
                                
                                switch(inputA.getFlagSector()){
                                        
                                        case "P": 

                                        Provincia provincia = provinciaService.getById( Integer.parseInt(inputA.getIdProvincia()) ) ;
                                       
                                        asignadorAgenteSectorial.asignar(provincia, usuario);

                                        case "M":

                                        Municipio municipio = municipioService.getByIdMunicipio( Integer.parseInt(inputA.getIdMunicipio()) ) ;
                                        asignadorAgenteSectorial.asignar(municipio, usuario);

                                       
                                }
                    
                    }    

            }
            
            catch (Exception ex) {
                    System.out.println("No se pudo Asignar el Agente Sectorial");     
            }
            return json(goodAnswer());
    
        } 

             
    }



    

