package dds.tp.carbono.http.controllers.admin;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import spark.Spark;
import spark.TemplateEngine;

public class AdminOrganizationController extends Controller {
    private static final String VIEW = "admin.organization.mustache";

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.ADMIN_ORG), (rq, rs) -> view(VIEW), engine); 
    }
}
