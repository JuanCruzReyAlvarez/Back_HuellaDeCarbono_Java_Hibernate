package dds.tp.carbono.http.controllers.transports;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.transport.LineaDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.transport.LineaService;
import spark.Spark;
import spark.Request;
import spark.Response;

public class LineaController extends Controller{
        private LineaService service;

        public LineaController( LineaService service) { 
            this.service = service;
        }

        @Override
        public void routes() {
            Spark.get(path(Uri.LINEAS), (rq, rs) -> this.getLineas(rq, rs));

        }

        private String  getLineas(Request rq, Response rs) throws Exception {
            try{
                    List<LineaDTO> listaDTO = new ArrayList<LineaDTO>();
                    List<Linea> lineas = service.getAllLineas();     
    
                    for (Linea linea : lineas)
                    {
                        LineaDTO obj= new LineaDTO();
                                   
                        obj.setId(String.valueOf(linea.getId()));
                        obj.setName(linea.getNombre());
    
                        listaDTO.add(obj);
                    }
                    
                    return json(listaDTO); 
    
                }catch(Exception exc){
                    throw new Exception("In catch Exception geting Lineas was fail: ");
                }  
        }


}









   

    