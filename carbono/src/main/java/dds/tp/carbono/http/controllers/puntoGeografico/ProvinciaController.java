package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.ArrayList;

import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.location.ProvinciaDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import spark.Spark;

import spark.Request;
import spark.Response;


public class ProvinciaController extends Controller {

    
    private ProvinciaService service;

      public ProvinciaController( ProvinciaService organizacionService ) { 
        this.service = organizacionService;
    }




    @Override
    public void routes( ) {
        
        Spark.get(path(Uri.PROVINCIA), (rq, rs) -> this.getProvincias(rq, rs));
    
    }

    public String  getProvincias(Request rq, Response rs) throws HttpException {
        
        try{

                List<ProvinciaDTO> listaDTO = new ArrayList<ProvinciaDTO>();
                List<Provincia> provincias = service.getAll();   

                for (Provincia prov:provincias)
                {
                    ProvinciaDTO obj= new ProvinciaDTO();
                               
                    obj.setId(String.valueOf(prov.getId()));
                    obj.setName(prov.getNombre());

                    listaDTO.add(obj);
                }
            
                
               
                System.out.println("Hola2");

                return json(listaDTO); 
            }
            catch(Exception ex){
                System.out.println("In catch Exception geting provincias was fail:");
            }

        return null;
    }

  }