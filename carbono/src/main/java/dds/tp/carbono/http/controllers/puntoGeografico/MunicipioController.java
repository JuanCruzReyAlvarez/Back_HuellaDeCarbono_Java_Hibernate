package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.location.MunicipioDTO;
import dds.tp.carbono.http.dto.location.ProvinciaDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.puntoGeografico.MunicipioService;
 import spark.Request;
import spark.Response;
import spark.Spark;


public class MunicipioController extends Controller {


    private MunicipioService service;

      public MunicipioController( MunicipioService organizacionService ) { 
        this.service = organizacionService;
    }
    
    @Override
    public void routes( ) {
        
        Spark.post(path(Uri.MUNICIPIO), (rq, rs) -> this.getMunicipio(rq, rs));
    }

    private String  getMunicipio(Request rq, Response rs) throws Exception {
        try{

               
                ProvinciaDTO input = getBody(rq, ProvinciaDTO.class,null); 

                List<Municipio> municipios = service.getById(Integer.parseInt(input.getId())); 
               
                List<MunicipioDTO> listaDTO = new ArrayList<MunicipioDTO>();
                
                

                for (Municipio muni:municipios)
                {
                    MunicipioDTO obj= new MunicipioDTO();
                               
                    obj.setId(String.valueOf(String.valueOf(muni.getId())));
                    obj.setName(muni.getNombre());

                    listaDTO.add(obj);
                }
               
                return json(listaDTO);
            }catch(Exception exc){
                throw new Exception(" In catch Exception geting municipios was fail: ");
            }  
    }

}

    
