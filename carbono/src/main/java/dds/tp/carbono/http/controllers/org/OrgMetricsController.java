package dds.tp.carbono.http.controllers.org;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.MultipartConfigElement;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.metrics.MetricsImporterService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class OrgMetricsController extends Controller {
    

    private static final String ACCESS_TYPE = "multipart/form-data";
    private static final String MULTIPART_DRIVER = "org.eclipse.jetty.multipartConfig";
    
    private OrganizacionService service;
    public OrgMetricsController() { 
       this.service = new OrganizacionService();
    }

    @Override
    public void routes( ) {
        //Spark.get(path(Uri.ORG_METRICS), (rq, rs) -> view(VIEW), engine);
        Spark.post(path(Uri.ORG_METRICS), ACCESS_TYPE, (rq, rs) -> this.uploadFile(rq, rs));
    }

    private String uploadFile(Request request, Response rs) throws HttpException {

        request.attribute(MULTIPART_DRIVER, new MultipartConfigElement("/temp"));

        try (InputStream is = request.raw().getPart("file").getInputStream()) {
            
          Integer userId = Integer.parseInt(request.queryParams("cookie")) ;

          System.out.println("HOLAAAA1");

          Organizacion organizacion = new Organizacion();
          
          organizacion = this.service.getByUser(userId);

          System.out.println("HOLAAAA2");
            
          MetricsImporterService metricsService = new MetricsImporterService(organizacion);

          System.out.println("HOLAAAA3");

          List<MetricaOrganizacion> metricas = new ArrayList();

          metricas = metricsService.importExcel(is);

          

          System.out.println("HOLAAAA4");
          System.out.println(organizacion.getId());
          System.out.println(metricas.get(0).getOrganizacion().getId());
            
          //metricsService.updateAll(metricas,organizacion.getId());

          System.out.println("HOLAAAA5");

          return json(goodAnswer());
        }
        catch (Exception ex) {
            System.out.println("Error en el controlador del excel en Spark");
        }
        return json(goodAnswer());
    }
}
