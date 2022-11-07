package dds.tp.carbono.http.controllers.org;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.OrgDTO;
import dds.tp.carbono.http.dto.org.UsuarioDTO;
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
        Spark.post(path(Uri.ORGANIZACION_NAME), (rq, rs) -> this.getOrganizacionName(rq, rs));
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
                    obj.setName(org.getRazonSocial());

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

            UsuarioDTO input = getBody(rq, UsuarioDTO.class,null); 

            OrgDTO DTO = new OrgDTO();
            Organizacion org = new Organizacion();
            OrganizacionRepository repo = new OrganizacionRepository();

            org = repo.getByUser( (Integer.valueOf( input.getId() ) ) );
            DTO.setName(org.getRazonSocial());
            DTO.setId(String.valueOf(org.getId()));

            return json(DTO); 
            
        }catch(Exception exc){
            throw new Exception("In catch Exception geting the name of Organizacion");
        }

    }

}