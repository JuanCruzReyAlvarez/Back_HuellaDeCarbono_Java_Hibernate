
package dds.tp.carbono.http.controllers.admin;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.auth.RolDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.admin.LogExistService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class LogExistController extends Controller {

    LogExistService service;

    public LogExistController(LogExistService service){
        this.service = service;
    }


    @Override
    public void routes() {
        Spark.post(path(Uri.LOGEXIST), (rq, rs) -> this.logExist(rq, rs));
    }
 

    private String logExist(Request rq, Response rs) throws Exception {

        try{
            RolDTO input = getBody(rq, RolDTO.class, null);
            Boolean rta = false;
            switch(input.getRol()){
                     
                case "MIEMBRO": 
                      rta = service.miembroExists(Integer.parseInt(input.getId()));   
                      break;  
                case "ORGANIZACION":
                      rta = service.organizacionExists(Integer.parseInt(input.getId()));   
                      break;                   
                case "AGENTE_SECTORIAL":
                      rta = service.sectorExists(Integer.parseInt(input.getId()));   
                      break; 
                }

                return json(rta); 

            }catch(Exception exc){
                System.out.println("Errorverificando si ya paso por hall");
            }
            return null;
        }
       
    }