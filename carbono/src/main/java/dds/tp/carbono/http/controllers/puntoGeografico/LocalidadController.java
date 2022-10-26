package dds.tp.carbono.http.controllers.puntoGeografico;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.location.LocalidadDTO;
import dds.tp.carbono.http.dto.location.MunicipioDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.puntoGeografico.LocalidadService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class LocalidadController extends Controller {


    private LocalidadService service;

      public LocalidadController( LocalidadService organizacionService ) { 
        this.service = organizacionService;
    }

    @Override
    public void routes( ) {
        Spark.post(path(Uri.LOCALIDAD), (rq, rs) -> this.getLocalidades(rq, rs));
    }

   

	private String  getLocalidades(Request rq, Response rs) throws Exception {

        try{
                
                MunicipioDTO input = getBody(rq, MunicipioDTO.class,null);
                List<Localidad> localidades = service.getById(Integer.parseInt(input.getId())); 
                List<LocalidadDTO> listaDTO = new ArrayList<LocalidadDTO>();
                
                for (Localidad loqui:localidades)
                {
                    LocalidadDTO obj= new LocalidadDTO();
                               
                    obj.setId(String.valueOf(loqui.getId()));
                    obj.setName(loqui.getNombre());

                    listaDTO.add(obj);
                }

                return json(listaDTO);        
               
            }catch(Exception exc){
                throw new Exception("In catch Exception geting localidades was fail: ");
            }  
    }

}