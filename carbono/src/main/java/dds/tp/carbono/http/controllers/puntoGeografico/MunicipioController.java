package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.puntoGeografico.MunicipioService;
import spark.TemplateEngine;
 import spark.Request;
import spark.Response;
import spark.Spark;


public class MunicipioController extends Controller {


    private MunicipioService service;

      public MunicipioController( MunicipioService organizacionService ) { 
        this.service = organizacionService;
    }
    
    @Override
    public void routes(TemplateEngine engine) {
        
        Spark.post(path(Uri.MUNICIPIO), (rq, rs) -> this.getMunicipio(rq, rs));
    }

    private String  getMunicipio(Request rq, Response rs) throws Exception {
        try{
                List<Municipio> municipios = service.getAll();            
                return json(municipios); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting municipios was fail: ");
            }  
    }

}

    
