package dds.tp.carbono.http.context;

import dds.tp.carbono.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.contracts.http.IController;
import dds.tp.carbono.http.controllers.admin.FactorEmisionController;
import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;
import dds.tp.carbono.http.controllers.agenteSectorial.CalcuarHuellaController;
import dds.tp.carbono.http.controllers.auth.HallController;
import dds.tp.carbono.http.controllers.auth.LoginController;
import dds.tp.carbono.http.controllers.auth.RegisterController;
import dds.tp.carbono.http.controllers.member.trayectos.PointController;
import dds.tp.carbono.http.controllers.member.trayectos.TrayectosController;
import dds.tp.carbono.http.controllers.org.ContactsController;
import dds.tp.carbono.http.controllers.org.OrgMetricsController;
import dds.tp.carbono.http.controllers.org.OrganizacionController;
import dds.tp.carbono.services.agenteSectorial.AsignadorDeAgentesSectoriales;
import dds.tp.carbono.services.auth.HallMiembroService;
import dds.tp.carbono.services.auth.HallOrganizacionService;
import dds.tp.carbono.services.auth.SolicitadorDeVinculacionService;
import dds.tp.carbono.services.organizacion.ContactsService;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.auth.LoginService;
import dds.tp.carbono.services.auth.RegisterService;

import spark.TemplateEngine;
import spark.servlet.SparkApplication;
import spark.template.mustache.MustacheTemplateEngine;

public class Server implements SparkApplication {

    private final int PORT = 8080;
    private final String PUBLIC_DIR = "/public";
    private final TemplateEngine TEMPLATE_ENGINE = new MustacheTemplateEngine();

    @Override
    public void init() {

        HttpContext http = new HttpContext(); 
        http.setip();
        IController[] controllers = registerControllers(); 

        http.setPort(PORT)
            .setStaticFilesLocation(PUBLIC_DIR)
            .setTemplateEngine(TEMPLATE_ENGINE)
            .addExceptionHandling()
            .addRouting(controllers);
    }

    
    

    private IController[] registerControllers() {
        return new IController[] {
            new LoginController(new LoginService()),
            new RegisterController(new RegisterService(new InsecurePasswordCheckerBuilder())),
            new OrganizacionController(new OrganizacionService()),
            new HallController( new HallMiembroService(),
                                new HallOrganizacionService(),
                                new SolicitadorDeVinculacionService(),
                                new AsignadorDeAgentesSectoriales() ),
            new OrgMetricsController(),
            new AdminGeoInfoController(),
            new TrayectosController(),
            new PointController(),
            new FactorEmisionController(),
            new CalcuarHuellaController(),
            new ContactsController(new ContactsService())
        };
    }
}