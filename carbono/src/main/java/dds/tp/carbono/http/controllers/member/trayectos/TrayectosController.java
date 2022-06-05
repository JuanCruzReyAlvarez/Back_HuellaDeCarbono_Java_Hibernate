package dds.tp.carbono.http.controllers.member.trayectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.member.trayectos.TrayectoDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import lombok.Getter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class TrayectosController extends Controller {
    
        private static final String VIEW = "member.trayectos.mustache";
        
        @Override
        public void routes(TemplateEngine engine) {
            Spark.get(path(Uri.MEMBER_TRAYECTOS), (rq, rs) -> this.trayectos(rq, rs), engine);
            Spark.get(path(Uri.MEMBER_TRAYECTOS_AUTOCOMPLETE), (rq, rs) -> this.autocomplete(rq, rs));
        }
    
        private String autocomplete(Request rq, Response rs) {

            // String typeSearch = rq.queryParams("type");
            String query = rq.queryParams("q");

            List<AutocompleteDTO> list = new ArrayList<AutocompleteDTO>() {{
                add(new AutocompleteDTO(true, "UTN FRBA - CAMPUS", 1));
                add(new AutocompleteDTO(true, "UTN FRBA - MEDRANO", 2));
            }}.stream().filter(i -> i.label.toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
            
            return json(list);
        }

        private ModelAndView trayectos(Request request, Response rs) throws HttpException {

            List<TrayectoDTO> trayectos = new ArrayList<TrayectoDTO>();

            trayectos.add(new TrayectoDTO(1, "Juan B. Justo 456", "UTN FRBA - Medrano", 3));
            trayectos.add(new TrayectoDTO(2, "UTN FRBA - Medrano", "Juan B. Justo 456", 2));

            return view(VIEW, Collections.singletonMap("trayectos", trayectos));
        }

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
}
