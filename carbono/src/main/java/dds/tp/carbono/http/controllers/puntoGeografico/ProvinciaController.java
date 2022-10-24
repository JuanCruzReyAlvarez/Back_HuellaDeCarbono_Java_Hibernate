package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.hadoop.shaded.com.nimbusds.jose.shaded.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.ProvinciaDTO;
import dds.tp.carbono.http.exceptions.HttpException;
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


    
    public String  getProvincias(Request rq, Response rs) throws HttpException {
        
        try{
                           

            
                List<Provincia> provincias = service.getAll(); 






                ProvinciaDTO obj= new ProvinciaDTO();
                obj.setId("55");
                obj.setName("juan dale que s epuede");
                /* 
                for (Provincia provincia: provincias){
                    aaa.add(provincia.getId()+ " "+ provincia.getNombre());
                     
                }*/
                
                //return gson.toJson(Stream.of(provincias).collect(Collectors.toList())); 
            
                //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                /* 
                ObjectMapper objectMapper = new ObjectMapper();
                
                System.out.println("Hola");
                Gson gson = new Gson();
                //List<String> a = Arrays.asList("");
                //List<String> aa = new List<String>();

                List<String> aaa = new ArrayList<String>();

                for (Provincia provincia: provincias){
                    aaa.add(provincia.getId()+ " "+ provincia.getNombre());
                     
                }

                System.out.println("Hola");
             */
                // return json(aaa); 

                    
                return json(obj); 
            }
            catch(Exception ex){
                System.out.println("In catch Exception geting provincias was fail:");
            }

        return null;
    }

  }