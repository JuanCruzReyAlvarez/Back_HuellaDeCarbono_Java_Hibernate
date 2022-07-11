package dds.tp.carbono.http.controllers.agenteSectorial;

import java.util.HashMap;
import java.util.Map;

import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.http.controllers.AuthorizationMiddleware;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.agenteSectorial.AgenteSectorialService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class CalcuarHuellaController extends AuthorizationMiddleware  {

    public CalcuarHuellaController() {
        super(Rol.AGENTE_SECTORIAL);
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.get(path(Uri.AGENTE_SECTORIAL_HUELLA), (rq, rs) -> this.calculoDeHuella(rq, rs));
        Spark.get(path(Uri.AGENTE_SECTORIAL), (rq, rs) -> this.agenteView(rq, rs), engine);
    }

    private ModelAndView agenteView(Request rq, Response rs) {

        Map<String, Object> datos = new HashMap<String, Object>();
        
        //voy a buscar el sector territorial asignado
        datos.put("sector", null);

        return this.view("agente.html", datos);
    }

    private String calculoDeHuella(Request rq, Response rs) {

        SessionCookie cookie = getSessionCookie(rq.cookie(TOKEN_COOKIE_NAME));

        AgenteSectorialService service = new AgenteSectorialService();
        try {
            String periodoParam = rq.queryParams("periodo");
            PeriodoDeImputacion periodo = new PeriodoDeImputacion(periodoParam);
            HuellaCarbono huella = service.calcularHuella(cookie.getUser(), periodo);
            return json(huella);
        } catch (Exception ex) {
            // return ex.getMessage();
            return json(cookie);
        } 
    }
}
