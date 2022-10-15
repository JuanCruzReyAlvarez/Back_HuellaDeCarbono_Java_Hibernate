package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;
import spark.Spark;
public class ProvinciaController extends Controller {

    
    private ProvinciaService service;

      public ProvinciaController( ProvinciaService organizacionService ) { 
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
        ProvinciaController.enableCORS();
        Spark.post(path(Uri.PROVINCIA), (rq, rs) -> this.getProvincias(rq, rs));
    }

    private String  getProvincias(Request rq, Response rs) throws Exception {
        try{
                List<Provincia> provincias = service.getAll();            
                return json(provincias); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting provincias was fail: ");
            }  
    }

}
