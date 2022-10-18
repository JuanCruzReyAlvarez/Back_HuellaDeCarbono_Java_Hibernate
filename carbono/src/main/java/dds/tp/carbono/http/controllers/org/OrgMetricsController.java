package dds.tp.carbono.http.controllers.org;

import java.io.InputStream;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.http.controllers.AuthorizationMiddleware;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.metrics.MetricsImporterService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class OrgMetricsController extends AuthorizationMiddleware {
    
    private static final String VIEW = "org/import.metrics.html";
    private static final String ACCESS_TYPE = "multipart/form-data";
    private static final String MULTIPART_DRIVER = "org.eclipse.jetty.multipartConfig";
   
    private OrganizacionService service;

    public OrgMetricsController() { 
        super(Rol.ORGANIZACION); 
        this.service = new OrganizacionService();
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.ORG_METRICS), (rq, rs) -> view(VIEW), engine);
        Spark.post(path(Uri.ORG_METRICS), ACCESS_TYPE, (rq, rs) -> this.uploadFile(rq, rs));
    }

    private String uploadFile(Request request, Response rs) throws HttpException {

        request.attribute(MULTIPART_DRIVER, new MultipartConfigElement("/temp"));
        
        try (InputStream is = request.raw().getPart("file").getInputStream()) {
            
            SessionCookie cookie = getSessionCookie(request.cookie(TOKEN_COOKIE_NAME));
            
            Organizacion org = this.service.getByUser(cookie.getUser());
            
            MetricsImporterService metricsService = new MetricsImporterService(org);

            List<MetricaOrganizacion> metricas = metricsService.importExcel(is);
            
            metricsService.saveAll(metricas,org.getId() );

           return json(cookie);
              
        } 
        catch (InvalidFileException invalidEx) {
            System.out.println("Error controller excel");
        } catch (Exception ex) {
            System.out.println("Error controller excel");
        }

        return null;
    }
}
