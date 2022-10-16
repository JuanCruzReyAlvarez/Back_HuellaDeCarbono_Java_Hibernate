package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.puntoGeografico.LocalidadService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class LocalidadController extends Controller {


    private LocalidadService service;

      public LocalidadController( LocalidadService organizacionService ) { 
        this.service = organizacionService;
    }

    private static void enableCORS() {
            
        Spark.options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

    }

    @Override
    public void routes(TemplateEngine engine) {
        //LocalidadController.enableCORS();
        Spark.post(path(Uri.LOCALIDAD), (rq, rs) -> this.getLocalidades(rq, rs));
    }

    private String  getLocalidades(Request rq, Response rs) throws Exception {
        try{
                List<Localidad> localidades = service.getAll();            
                return json(localidades); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting localidades was fail: ");
            }  
    }

}