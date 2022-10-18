package dds.tp.carbono.http.controllers.member.trayectos;


import java.util.List;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.member.trayectos.TrayectoDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.distancia.TrayectoService;

import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class TrayectosController extends Controller {
    
        private TrayectoService service;
        private MiembroService miembroService;
        

        public TrayectosController( TrayectoService service, MiembroService miembroService  ) { 
        this.service = service;
        this.miembroService =  miembroService;
        }
        
        @Override
        public void routes(TemplateEngine engine) {
            Spark.get(path(Uri.TRAYECTO), (rq, rs) -> this.trayectos(rq, rs));
            Spark.get(path(Uri.TRAYECTOS_AUTOCOMPLETE), (rq, rs) -> this.autocomplete(rq, rs));
        }

        private String trayectos(Request rq, Response rs) throws Exception {

            try {
            TrayectoDTO input = getBody(rq, TrayectoDTO.class,null);
            Miembro miembro = miembroService.getById(Integer.parseInt(input.getIdMiembro()));
            PuntoGeografico desde = new PuntoGeografico(Integer.parseInt(input.getLocalidadDesdeId()));
            PuntoGeografico hasta = new PuntoGeografico(Integer.parseInt(input.getLocalidadHastaId()));
            List<Tramo> tramos = input.getTramos(); //Esto esta mal hay que formarlo aca en base  adatos del DTO
            Trayecto trayecto = new Trayecto(desde,hasta, tramos, miembro); 

            service.crear(trayecto);

            return (json(goodAnswer()));
            }catch(HttpException exc)
            {
                System.out.println("Error por controller trayectos");
            }
			return null;
        }


        private String autocomplete(Request rq, Response rs) throws HttpException{
            /* 
            try {

                //TrayectoDTO input = getBody(rq, TrayectoDTO.class,null);
               // Miembro miembro = miembroService.getById(Integer.parseInt(input.getIdMiembro()));
                //TrayectoPendiente = 
                //return json(usuario);

            } catch (InsecurePasswordException ex) {
                System.out.println("Error por controller autocomplete");
            }

            */
            return null;
        }


/* 
        private class AutocompleteDTO {
            @Getter private boolean isOrg;
            @Getter private String label;
            @Getter private Integer ubicacionId;

            public AutocompleteDTO(boolean isOrg, String label, Integer ubicacionId) {
                this.isOrg = isOrg;
                this.label = label;
                this.ubicacionId = ubicacionId;
            }
        }
*/
}
