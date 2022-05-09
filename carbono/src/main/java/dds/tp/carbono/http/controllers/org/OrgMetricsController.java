package dds.tp.carbono.http.controllers.org;

import dds.tp.carbono.contracts.services.org.IOrgMetricsService;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import spark.Spark;
import spark.TemplateEngine;

public class OrgMetricsController extends Controller {
    
    private static final String VIEW = "org.metrics.mustache";
    
    private IOrgMetricsService service;

    public OrgMetricsController(IOrgMetricsService service) {
        this.service = service;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.ORG_METRICS), (rq, rs) -> view(VIEW), engine);
    }
}
