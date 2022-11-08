package dds.tp.carbono.http.controllers.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.OrgDTO;
import dds.tp.carbono.http.dto.org.SectorDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.SectorService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class SectorController extends Controller{
    private SectorService service;
    private OrganizacionService serviceOrg;

      public SectorController( SectorService service, OrganizacionService serviceOrg ) { 
        this.service = service;
        this.serviceOrg = serviceOrg;
    }

    @Override
    public void routes() {
        Spark.post(path(Uri.SECTORES), (rq, rs) -> this.getSectores(rq, rs));
        Spark.post(path(Uri.SECTORES_BY), (rq, rs) -> this.getSectoresByRrg(rq, rs));
    }

    private String  getSectores(Request rq, Response rs) throws HttpException {
        try{
                
                OrgDTO input = getBody(rq, OrgDTO.class,null); 

                List<Sector> sectores = service.getByOrg(Integer.parseInt(input.getId())); 
               
                List<SectorDTO> listaDTO = new ArrayList<SectorDTO>();
                
                

                for (Sector sect:sectores)
                {
                    SectorDTO obj= new SectorDTO();
                               
                    obj.setIdSector(String.valueOf(String.valueOf(sect.getId())));
                    obj.setNombre(sect.getNombre());

                    listaDTO.add(obj);
                }
               
                return json(listaDTO);
                
               
            }catch(Exception exc){
                System.out.println("In catch Exception creating sector in controler was fail:");
            }  
        return null;
    }

    private String  getSectoresByRrg(Request rq, Response rs) throws HttpException {
        try{
                
                OrgDTO input = getBody(rq, OrgDTO.class,null); 

                Set<Sector> sectores = serviceOrg.getById(Integer.parseInt(input.getId())).getSectores(); 
               
                List<SectorDTO> listaDTO = new ArrayList<SectorDTO>();
                
                for (Sector sect:sectores)
                {
                    SectorDTO obj= new SectorDTO();
                               
                    obj.setIdSector(String.valueOf(String.valueOf(sect.getId())));
                    obj.setNombre(sect.getNombre());

                    listaDTO.add(obj);
                }
               
                return json(listaDTO);
                
               
            }catch(Exception exc){
                System.out.println("In catch Exception creating sector in controler was fail:");
            }  
        return null;
    }

}
