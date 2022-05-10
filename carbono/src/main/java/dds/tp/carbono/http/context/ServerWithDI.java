package dds.tp.carbono.http.context;

import dds.tp.carbono.IoC.ContextManager;
import dds.tp.carbono.contracts.IoC.IContext;
import dds.tp.carbono.contracts.http.IController;
import dds.tp.carbono.contracts.services.auth.ILoginService;
import dds.tp.carbono.contracts.services.auth.IRegisterService;
import dds.tp.carbono.contracts.services.org.IOrgMetricsService;
import dds.tp.carbono.http.controllers.admin.ui.AdminOrganizationController;
import dds.tp.carbono.http.controllers.auth.LoginController;
import dds.tp.carbono.http.controllers.auth.RegisterController;
import dds.tp.carbono.http.controllers.member.trayectos.TrayectosController;
import dds.tp.carbono.http.controllers.org.OrgMetricsController;
import spark.TemplateEngine;
import spark.servlet.SparkApplication;
import spark.template.mustache.MustacheTemplateEngine;

public class ServerWithDI implements SparkApplication {

    private final int PORT = 8080;
    private final String PUBLIC_DIR = "/public";
    private final TemplateEngine TEMPLATE_ENGINE = new MustacheTemplateEngine();

    @Override
    public void init() {  
        IContext ctx = ContextManager.getContext();
        HttpContext http = new HttpContext(); 
        IController[] controllers = registerControllers(ctx);

        http.setPort(PORT)
            .setStaticFilesLocation(PUBLIC_DIR)
            .setTemplateEngine(TEMPLATE_ENGINE)
            .addExceptionHandling()
            .addRouting(controllers);
    }

    private IController[] registerControllers(IContext ctx) {
        return new IController[] {
            new LoginController(ctx.get(ILoginService.class)),
            new RegisterController(ctx.get(IRegisterService.class)),
            new OrgMetricsController(ctx.get(IOrgMetricsService.class)),
            new AdminOrganizationController(),
            new TrayectosController()
        };
    }
}