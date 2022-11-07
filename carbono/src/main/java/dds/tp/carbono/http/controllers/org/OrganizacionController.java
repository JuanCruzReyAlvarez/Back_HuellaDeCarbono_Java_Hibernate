package dds.tp.carbono.http.controllers.org;
import java.util.ArrayList;
import java.util.List;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.OrgDTO;
import dds.tp.carbono.http.dto.org.OrgNameDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
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
        Spark.get(path(Uri.ORGANIZACION), (rq, rs) -> this.getOrganizaciones(rq, rs));
        Spark.get(path(Uri.ORGANIZACION_NAME), (rq, rs) -> this.getOrganizacionName(rq, rs));
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

    private String getOrganizacionName(Request rq, Response rs) throws Exception{

        try{

            OrgDTO input = getBody(rq, OrgDTO.class,null); 

            OrgNameDTO DTO = new OrgNameDTO();
            Organizacion org = new Organizacion();
            OrganizacionRepository repo = new OrganizacionRepository();
            
            System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(input.getId());
            System.out.println("holaaaaaaaaaaaaaaaaa");
            org = repo.getById(  Integer.valueOf(input.getId())  );
            System.out.println("hola jejeje2222");
            DTO.setName(org.getRazonSocial());
            System.out.println("hola jejeje33333");

            return json(DTO); 

        }catch(Exception exc){
            throw new Exception("In catch Exception geting the name of Organizacion");
        }

    }

}