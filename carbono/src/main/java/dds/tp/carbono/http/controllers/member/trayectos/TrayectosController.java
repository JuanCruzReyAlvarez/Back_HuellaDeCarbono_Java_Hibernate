package dds.tp.carbono.http.controllers.member.trayectos;


import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.distancia.TrayectoService;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import spark.Request;
import spark.Response;
import spark.Spark;

public class TrayectosController extends Controller {
    
        private TrayectoService service;
        private MiembroService miembroService;
        

        public TrayectosController( TrayectoService service, MiembroService miembroService  ) { 
        this.service = service;
        this.miembroService =  miembroService;
        }
        
        @Override
        public void routes( ) {
            Spark.post(path(Uri.TRAYECTO), (rq, rs) -> this.trayectos(rq, rs));
            Spark.get(path(Uri.TRAYECTOS_AUTOCOMPLETE), (rq, rs) -> this.autocomplete(rq, rs));
        }

        private String trayectos(Request rq, Response rs) throws Exception {

            try {
                List<TramoDTO> tramosDTO = new ArrayList<TramoDTO>();
                Type listType = new TypeToken<ArrayList<TramoDTO>>(){}.getType();
                tramosDTO = new Gson().fromJson(rq.body(), listType);


                Trayecto trayecto = new Trayecto();

                List<Tramo> tramos = new ArrayList<Tramo>();

                Miembro miembro = new Miembro();
                miembro = miembroService.getByUserId(Integer.parseInt(tramosDTO.get(0).getUserId()));
                System.out.println(miembro.getId());
                trayecto.setMiembro(miembro);

                for(TramoDTO tramoDTO: tramosDTO){
                    Tramo tramo = new Tramo();
                    tramo = service.setTransporte(tramo,tramoDTO);
                    System.out.println("SETIE LOS TRANSPORTES");

                    tramo = service.setPuntosLlegadasTramo(tramoDTO,tramo);
                    System.out.println("SETIE LOS PUNTOS DE LLEGADA");

                    tramo = service.setAcompaniantes(tramo,tramoDTO);
                    System.out.println("SETIEACOMPANIANTES");

                    tramos.add(tramo);
            
                }

                trayecto.setTramos(tramos);
                trayecto.setFecha(LocalDate.now());
                trayecto = service.setInicioYFin(trayecto);

                System.out.println("Acaaaa5555");
                //System.out.println(trayecto.getTramos().get(0).getCompartidos().get(0).getNombre());


                service.crear(trayecto);

            return (json(goodAnswer()));
            
            }catch(Exception exc)
            {
                System.out.println("Error por controller trayectos");
            }
            
            
			
            return null ;

        }


        private String autocomplete(Request rq, Response rs) throws HttpException{
            /* 
            try {

                //TrayectoDTO input = getBody(rq, TrayectoDTO.class,null);
               // Miembro miembro = miembroService.getById(Integer.parseInt(input.getIdMiembro()));
                //TrayectoPendiente = 
                //return json(usuario);

            } catch (Exception ex) {
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
