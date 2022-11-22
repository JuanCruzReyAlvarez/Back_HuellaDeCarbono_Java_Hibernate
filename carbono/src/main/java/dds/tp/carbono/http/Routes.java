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
        define(Uri.LOGINRECOMEND, "/loginrecomend"),
        define(Uri.REGISTER, "/register"),
        define(Uri.HALL, "/hall"),
        define(Uri.PROVINCIA, "/provinciasss"),
        define(Uri.REQUEST, "/request"),
        define(Uri.MOD_REQUEST, "/modrequest"),
        define(Uri.AGREGAR_SECTORES, "/addsector"),
        define(Uri.SOL_MIEMBRO, "/solMiembro"),
        define(Uri.LOCALIDAD, "/localidad"),    
        define(Uri.MUNICIPIO, "/municipio"),
        define(Uri.TRAYECTO, "/trayecto"),
        define(Uri.TRAYECTOS_AUTOCOMPLETE, "/trayectoAutoComplete"),
        define(Uri.SECTORES, "/sectores"), 
        define(Uri.MEMBER, "/miembros"),
        define(Uri.SECTORES_BY, "/sectoresOrg"),
        define(Uri.ORGANIZACION, "/organizacion"),
        define(Uri.AGENTE_SECTORIAL, "/agente"),
        define(Uri.CONTACTS, "/contacts"),
        define(Uri.ADD_CONTACTS, "/addContacts"),
        define(Uri.ORGANIZACION_NAME,"/organizacionName"),
        define(Uri.SECTORES_ADD,"/addSector"),
        define(Uri.CREATE_REQUEST,"/createRequest"),
        define(Uri.LINEAS,"/lineas"),
        define(Uri.LOGEXIST,"/logExist"),
        define(Uri.ORG_METRICS, "/metrics"),
        define(Uri.ORG_REPORT, "/getReport"),
        define(Uri.ADMIN_FACTOR_EMISION, "/emissions"),
        define(Uri.ADMIN_GET_FACTOR_EMISION, "/getEmissions"),
        define(Uri.ADMIN_GEOINFO_TRANSPORTS, "/geoInfoAdminTransports"),
     
        

        
        
        
        
        
    // ------------------------------------------------------------------------------- Huella
        define(Uri.CALCULATOR, "/calculators"),
    // ------------------------------------------------------------------------------- Dto 

    // -------------------------------------------------------------------------------- organization  
        
    // -------------------------------------------------------------------------------- admin
        define(Uri.ADMIN, "/admin", 
        define(Uri.ADMIN_GEOINFO, "/geoInfoAdmin")  
        ),
    // -------------------------------------------------------------------------------- member
       
        define(Uri.MEMBER_POINTS, "/points", 
        define(Uri.MEMBER_POINTS_AUTOCOMPLETE, "/autocomplete")), 
        define(Uri.MEMBER_TRAYECTOS, "/trayectos",
        define(Uri.MEMBER_TRAYECTOS_AUTOCOMPLETE, "/autocomplete")));
    


   
        //define(Uri.AGENTE_SECTORIAL_HUELLA, "/huella")));
        
  
          


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
