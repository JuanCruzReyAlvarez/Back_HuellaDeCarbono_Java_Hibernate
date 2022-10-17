package dds.tp.carbono.http.controllers.org;

import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.SectorDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.SectorService;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateEngine;

public class SectorController extends Controller{
    private SectorService service;

      public SectorController( SectorService service ) { 
        this.service = service;
    }

    @Override
    public void routes(TemplateEngine engine) {
        Spark.post(path(Uri.AGREGAR_SECTORES), (rq, rs) -> this.addSector(rq, rs));
    }

    private String  addSector(Request rq, Response rs) throws HttpException {
        try{
                SectorDTO input = getBody(rq, SectorDTO.class, null);
                Sector sector = new Sector(input.getNombre(),input.getIdOrganizacion());     
                service.repository.guardar(sector);

                return json(goodAnswer());
            }catch(Exception exc){
                System.out.println("In catch Exception creating sector in controler was fail:");
            }  
        return null;
    }


}
