package dds.tp.carbono.http;

import java.util.Map;
import java.util.TreeMap;

import dds.tp.carbono.http.utils.Route;
import dds.tp.carbono.http.utils.Uri;
import lombok.Getter;

public class Routes {

    public void init() {

    // -------------------------------------------------------------------------------- root 
        this.api = define(Uri.ROOT, "",
    // -------------------------------------------------------------------------------- auth 
        define(Uri.LOGIN, "/login"),
        define(Uri.REGISTER, "/register"),
        define(Uri.HALL, "/hall"),
        define(Uri.PROVINCIA, "/provinciasss"),
        define(Uri.REQUEST, "/request"),
        define(Uri.MOD_REQUEST, "/modrequest"),
        define(Uri.AGREGAR_SECTORES, "/addsector"),
    // ------------------------------------------------------------------------------- Huella
        define(Uri.CALCULATOR, "/calculators"),
    // ------------------------------------------------------------------------------- Dto 
        define(Uri.LOCALIDAD, "/localidad"),    
        define(Uri.MUNICIPIO, "/municipio"),
    // -------------------------------------------------------------------------------- organization  
        define(Uri.ORGANIZACION, "/organizacion",
    // -------------------------------------------------------------------------------- admin
        define(Uri.ADMIN, "/admin", 
        define(Uri.ADMIN_GEOINFO, "/geoInfoAdmin"),  
        define(Uri.ADMIN_FACTOR_EMISION, "/fe")),
    // -------------------------------------------------------------------------------- member
        define(Uri.MEMBER, "/member",
        define(Uri.MEMBER_POINTS, "/points", 
        define(Uri.MEMBER_POINTS_AUTOCOMPLETE, "/autocomplete")), 
        define(Uri.MEMBER_TRAYECTOS, "/trayectos",
        define(Uri.MEMBER_TRAYECTOS_AUTOCOMPLETE, "/autocomplete"))),
    


        define(Uri.ORG_METRICS, "/metrics")),
        define(Uri.AGENTE_SECTORIAL, "/agente",
        define(Uri.AGENTE_SECTORIAL_HUELLA, "/huella")));
        define(Uri.CONTACTS, "/contacts");
  
          


        paths = api.branches();
    }

    private Route define(Uri uri, String path, Route... children) {
        return new Route(uri, path, children);
    }

    private Route api;
    @Getter private Map<Uri, String> paths = new TreeMap<>();

    private static Routes instance;

    public static Routes getInstance() {
        if (instance == null) {
            instance = new Routes();
            instance.init();
        }

        return instance;
    }
}
