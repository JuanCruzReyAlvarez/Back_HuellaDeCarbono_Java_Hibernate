package dds.tp.carbono.http.controllers.org;
import java.util.ArrayList;
import java.util.List;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.OrgDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import spark.Spark;
import spark.Request;
import spark.Response;

public class OrganizacionController extends Controller{

    private OrganizacionService service;

      public OrganizacionController( OrganizacionService organizacionService ) { 
        this.service = organizacionService;
    }


    @Override
    public void routes() {
        System.out.println("PRUEBAJEJJE 1 ");
        Spark.get(path(Uri.ORGANIZACION), (rq, rs) -> this.getOrganizaciones(rq, rs));
        System.out.println("PRUEBAJEJJE 1 ");
    }

    private String  getOrganizaciones(Request rq, Response rs) throws Exception {
        try{

                System.out.println("PRUEBAJEJJE 99 ");
                List<OrgDTO> listaDTO = new ArrayList<OrgDTO>();
                List<Organizacion> organizaciones = service.getAll();     

                for (Organizacion org:organizaciones)
                {
                    OrgDTO obj= new OrgDTO();
                               
                    obj.setId(String.valueOf(org.getId()));
                    obj.setRazonSocial(org.getRazonSocial());

                    listaDTO.add(obj);
                }
                
                System.out.println("PRUEBAJEJJE");
                return json(listaDTO); 

            }catch(Exception exc){
                throw new Exception("In catch Exception geting Organizaciones was fail: ");
            }  
    }

}