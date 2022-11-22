package dds.tp.carbono.http.context;

import dds.tp.carbono.contracts.http.IController;
import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;
import dds.tp.carbono.http.controllers.admin.FactorEmisionController;
import dds.tp.carbono.http.controllers.admin.LogExistController;
import dds.tp.carbono.http.controllers.auth.HallController;
import dds.tp.carbono.http.controllers.auth.LoginController;
import dds.tp.carbono.http.controllers.auth.RegisterController;
import dds.tp.carbono.http.controllers.member.trayectos.TrayectosController;
import dds.tp.carbono.http.controllers.org.ContactsController;
import dds.tp.carbono.http.controllers.org.MiembroController;
import dds.tp.carbono.http.controllers.org.OrgMetricsController;
import dds.tp.carbono.http.controllers.org.OrganizacionController;
import dds.tp.carbono.http.controllers.org.RequestController;
import dds.tp.carbono.http.controllers.org.SectorController;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.admin.LogExistService;
import dds.tp.carbono.services.agenteSectorial.AsignadorDeAgentesSectoriales;
import dds.tp.carbono.services.auth.HallMiembroService;
import dds.tp.carbono.services.auth.HallOrganizacionService;
import dds.tp.carbono.services.auth.SolicitadorDeVinculacionService;
import dds.tp.carbono.services.distancia.TrayectoService;
import dds.tp.carbono.services.external.puntoGeografico.LocalidadService;
import dds.tp.carbono.services.external.puntoGeografico.MunicipioService;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import dds.tp.carbono.services.huella.CalculatorService;
import dds.tp.carbono.services.organizacion.ContactsService;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.SectorService;
import dds.tp.carbono.services.reportes.ServicioReportes;
import dds.tp.carbono.services.transport.LineaService;
import dds.tp.carbono.services.auth.LoginService;
import dds.tp.carbono.services.auth.RegisterService;
import dds.tp.carbono.http.controllers.puntoGeografico.ProvinciaController;
import dds.tp.carbono.http.controllers.reportes.ReportesController;
import dds.tp.carbono.http.controllers.transports.LineaController;
import dds.tp.carbono.http.controllers.puntoGeografico.LocalidadController;
import dds.tp.carbono.http.controllers.puntoGeografico.MunicipioController;
import dds.tp.carbono.http.controllers.huella.CalculatorController;
import dds.tp.carbono.services.organizacion.RequestService;
import spark.servlet.SparkApplication;

public class Server implements SparkApplication {

    //private final int PORT = 8080;
    private final String PUBLIC_DIR = "/public";
    //private final TemplateEngine TEMPLATE_ENGINE = new MustacheTemplateEngine();

    @Override
    public void init() {

        HttpContext http = new HttpContext(); 
        http.setip();
        IController[] controllers = registerControllers(); 

        http.setPort(this.getHerokuAssignedPort()) 
            .setStaticFilesLocation(PUBLIC_DIR)
            .addExceptionHandling()
            .addRouting(controllers);
    }

    public int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    
    

    private IController[] registerControllers() {
        return new IController[] {
            new LoginController(new LoginService()),
            new RegisterController(new RegisterService()),
            new SectorController(new SectorService(),new OrganizacionService()),
            new ProvinciaController(new ProvinciaService()),
            new LocalidadController(new LocalidadService()),
            new MunicipioController(new MunicipioService()),
            new OrganizacionController(new OrganizacionService(), new MiembroService()),
            new HallController( new HallMiembroService(),
                                new HallOrganizacionService(),
                                new SolicitadorDeVinculacionService(),
                                new AsignadorDeAgentesSectoriales(),
                                new MunicipioService(),
                                new ProvinciaService(),
                                new SectorService()),
            new AdminGeoInfoController(),
            new TrayectosController(new TrayectoService(), new MiembroService()),
            new MiembroController (new MiembroService(), new SectorService()),
            new ContactsController(new ContactsService()),
            new CalculatorController(new CalculatorService(),new OrganizacionService(),new MiembroService(), new SectorService(), new ServicioReportes()),
            new RequestController(new RequestService()),
            new LineaController( new LineaService()),
            new LogExistController(new LogExistService()),
            new OrgMetricsController(),
            new ReportesController(new ServicioReportes()),
            new FactorEmisionController()
        };
    }
}