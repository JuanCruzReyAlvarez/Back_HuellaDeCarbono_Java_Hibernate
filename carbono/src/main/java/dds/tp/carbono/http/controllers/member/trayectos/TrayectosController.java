package dds.tp.carbono.http.controllers.member.trayectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.member.trayectos.TrayectoDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class TrayectosController extends Controller {
    
        private static final String VIEW = "member.trayectos.mustache";
        
        // private IOrgMetricsService service;
    
        // public TrayectosController(ITrayectoService service) {
            // this.service = service;
        // }
    
        @Override
        public void routes(TemplateEngine engine) {
            Spark.get(path(Uri.MEMBER_TRAYECTOS), (rq, rs) -> this.trayectos(rq, rs), engine);
        }
    
        private ModelAndView trayectos(Request request, Response rs) throws HttpException {

            List<TrayectoDTO> trayectos = new ArrayList<TrayectoDTO>();

            trayectos.add(new TrayectoDTO(1, "Juan B. Justo 456", "UTN FRBA - Medrano", 3));
            trayectos.add(new TrayectoDTO(2, "UTN FRBA - Medrano", "Juan B. Justo 456", 2));

            return view(VIEW, Collections.singletonMap("trayectos", trayectos));
        }
}
