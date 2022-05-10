package dds.tp.carbono.http;

import java.util.Map;
import java.util.TreeMap;

import dds.tp.carbono.http.utils.Route;
import dds.tp.carbono.http.utils.Uri;
import lombok.Getter;

public class Routes {
    private static final String ROOT      = "";
    private static final String LOGIN     = "/login";
    private static final String REGISTER  = "/register";
    private static final String ADMIN     = "/admin";
    private static final String ORG       = "/org";
    private static final String MEMBER    = "/member";
    private static final String TRAYECTOS = "/trayectos";
    private static final String METRICS   = "/metrics";
    
    public void init() {
        this.api = new Route(Uri.ROOT, ROOT, new Route[] {
            new Route(Uri.LOGIN, LOGIN),
            new Route(Uri.REGISTER, REGISTER),
            new Route(Uri.ADMIN, ADMIN, new Route[] {
                new Route(Uri.ADMIN_ORG, ORG)
            }),
            new Route(Uri.MEMBER, MEMBER, new Route[] {
                new Route(Uri.MEMBER_TRAYECTOS, TRAYECTOS)
            }),
            new Route(Uri.ORG, ORG, new Route[] {
                new Route(Uri.ORG_METRICS, METRICS)
            })
        });

        paths = api.branches();
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
