package dds.tp.carbono.http.controllers.org;
import java.util.List;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import spark.Spark;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;

public class OrganizacionController extends Controller{

    private OrganizacionService service;

      public OrganizacionController( OrganizacionService organizacionService ) { 
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
        OrganizacionController.enableCORS();
        Spark.post(path(Uri.ORGANIZACION), (rq, rs) -> this.getOrganizaciones(rq, rs));
    }

    private String  getOrganizaciones(Request rq, Response rs) throws Exception {
        try{
                List<Organizacion> organizaciones = service.getAll();            
                return json(organizaciones); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting Organizaciones was fail: ");
            }  
    }

}