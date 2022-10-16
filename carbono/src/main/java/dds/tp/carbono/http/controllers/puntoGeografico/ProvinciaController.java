package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.controllers.auth.RegisterController;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import spark.Spark;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;


public class ProvinciaController extends Controller {

    
    private ProvinciaService service;

      public ProvinciaController( ProvinciaService organizacionService ) { 
        this.service = organizacionService;
    }




    @Override
    public void routes(TemplateEngine engine) {
        System.out.println("llehgo a compilar las rutas");     

        Spark.get(path(Uri.PROVINCIA), (rq, rs) -> this.getProvincias(rq, rs));
        

        System.out.println("llehgo a compilar las rutas  2222"); 
    }

    private String  getProvincias(Request rq, Response rs) throws Exception {
        
        try{
                System.out.println("tefi funco eh");           
                List<Provincia> provincias = service.getAll(); 
                return json(provincias); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting provincias was fail: ");
            }  
    }

}
