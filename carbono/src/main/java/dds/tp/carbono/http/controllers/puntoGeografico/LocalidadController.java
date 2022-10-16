package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.puntoGeografico.LocalidadService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class LocalidadController extends Controller {


    private LocalidadService service;

      public LocalidadController( LocalidadService organizacionService ) { 
        this.service = organizacionService;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.post(path(Uri.LOCALIDAD), (rq, rs) -> this.getLocalidades(rq, rs));
    }

    private String  getLocalidades(Request rq, Response rs) throws Exception {
        try{
                List<Localidad> localidades = service.getAll();            
                return json(localidades); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting localidades was fail: ");
            }  
    }

}