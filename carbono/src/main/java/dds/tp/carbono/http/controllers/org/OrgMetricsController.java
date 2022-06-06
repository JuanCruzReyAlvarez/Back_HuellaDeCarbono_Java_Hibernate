package dds.tp.carbono.http.controllers.org;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import com.google.gson.Gson;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.reader.ExcelImporter;
import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

@Slf4j
public class OrgMetricsController extends Controller {
    
    private static final String VIEW = "org.metrics.mustache";
    private static final String ACCESS_TYPE = "multipart/form-data";
    private static final String MULTIPART_DRIVER = "org.eclipse.jetty.multipartConfig";

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.ORG_METRICS), (rq, rs) -> view(VIEW), engine);
        Spark.post(path(Uri.ORG_METRICS), ACCESS_TYPE, (rq, rs) -> this.uploadFile(rq, rs), engine);
    }

    private ModelAndView uploadFile(Request request, Response rs) throws HttpException {
        request.attribute(MULTIPART_DRIVER, new MultipartConfigElement("/temp"));
        
        try (InputStream is = request.raw().getPart("file").getInputStream()) {
            ExcelImporter importer = new ExcelImporter();
            List<ImportableModel> excelData = importer.importFrom(is, ImportableModel.class);
            log.info(new Gson().toJson(excelData));
           
            return view(VIEW, Collections.singletonMap("metrics", excelData));
        } catch (Exception ex) {
            return view(VIEW, Collections.singletonMap("errors", Collections.singletonMap("error", ex.getMessage())));
        }
    }
}
