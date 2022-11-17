

package dds.tp.carbono.http.controllers.org;

import java.io.InputStream;
import java.util.List;



import javax.servlet.MultipartConfigElement;

import com.google.gson.Gson;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.http.controllers.AuthorizationMiddleware;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.metrics.MetricsImporterService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class OrgMetricsController extends Controller {
    
    //private static final String VIEW = "org/import.metrics.html";
    private static final String ACCESS_TYPE = "multipart/form-data";
    private static final String MULTIPART_DRIVER = "org.eclipse.jetty.multipartConfig";
   
    private OrganizacionService service;

    //public OrgMetricsController() { 
       // super(Rol.ORGANIZACION); 
        //this.service = new OrganizacionService();
    //}

    @Override
    public void routes( ) {
        //Spark.get(path(Uri.ORG_METRICS), (rq, rs) -> view(VIEW), engine);
        Spark.post(path(Uri.ORG_METRICS), ACCESS_TYPE, (rq, rs) -> this.uploadFile(rq, rs));
    }

    private String uploadFile(Request request, Response rs) throws HttpException {
        request.attribute(MULTIPART_DRIVER, new MultipartConfigElement("/temp"));
        System.out.println("JAJAJAJJAJAJAJAJAJAJAJJABUENAS");
        //InputStream is = request.raw().getPart("file").getInputStream()
        try{

           
            
            String tramosDTO = new Gson().toJson(request.body());

            System.out.println(tramosDTO);
            
            System.out.println("JEJEJEJJEJEJE");
            InputStream is = request.raw().getInputStream();
            System.out.println(is);   
            //SessionCookie cookie = getSessionCookie(request.cookie(TOKEN_COOKIE_NAME));
            
            //Organizacion org = this.service.getByUser(cookie.getUser().getId());
            
            //MetricsImporterService metricsService = new MetricsImporterService(org);

            //List<MetricaOrganizacion> metricas = metricsService.importExcel(is);
            
           // metricsService.saveAll(metricas,org.getId());

           return json(goodAnswer());
              
        } 
        catch(Exception ex) {
            System.out.println("Error controller excel");
        }

        return null;
    }
}

