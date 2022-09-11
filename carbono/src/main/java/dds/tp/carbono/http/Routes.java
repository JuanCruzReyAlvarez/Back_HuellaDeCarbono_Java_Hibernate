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
    // -------------------------------------------------------------------------------- admin
        define(Uri.ADMIN, "/admin", 
            define(Uri.ADMIN_ORG, "/org"), 
            define(Uri.ADMIN_FACTOR_EMISION, "/fe")),
    // -------------------------------------------------------------------------------- member
        define(Uri.MEMBER, "/member",
            define(Uri.MEMBER_POINTS, "/points",
                define(Uri.MEMBER_POINTS_AUTOCOMPLETE, "/autocomplete")),
            define(Uri.MEMBER_TRAYECTOS, "/trayectos",
                define(Uri.MEMBER_TRAYECTOS_AUTOCOMPLETE, "/autocomplete"))),
    // -------------------------------------------------------------------------------- organization  
        define(Uri.ORG, "/org",
            define(Uri.ORG_METRICS, "/metrics")),
        define(Uri.AGENTE_SECTORIAL, "/agente",
            define(Uri.AGENTE_SECTORIAL_HUELLA, "/huella")));


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
