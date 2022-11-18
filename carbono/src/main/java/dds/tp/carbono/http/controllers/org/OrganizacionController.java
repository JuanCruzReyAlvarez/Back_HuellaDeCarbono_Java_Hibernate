package dds.tp.carbono.http.controllers.org;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.OrgDTO;
import dds.tp.carbono.http.dto.org.UsuarioDTO;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import spark.Spark;
import spark.Request;
import spark.Response;

public class OrganizacionController extends Controller{

    private OrganizacionService service;
    private MiembroService ms;

      public OrganizacionController( OrganizacionService organizacionService,  MiembroService ms ) { 
        this.service = organizacionService;
        this.ms = ms;
    }


    @Override
    public void routes() {
        Spark.get(path(Uri.ORGANIZACION), (rq, rs) -> this.getOrganizaciones(rq, rs));
        Spark.post(path(Uri.ORGANIZACION_NAME), (rq, rs) -> this.getOrganizacionName(rq, rs));
    }

    private String  getOrganizaciones(Request rq, Response rs) throws Exception {
        try{
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

            
            switch(input.getRol()){
                     
                case "MIEMBRO": 
                {

                Miembro r = new Miembro();
                OrgDTO sDTO= new OrgDTO();
                SectorRepository repo = new SectorRepository();

                List<Miembro> miembros =  ms.getAll(); 
        
                for (Miembro m:miembros   ){     
                if((m.getUser().getId()).equals(Integer.valueOf(input.getId())) ){r = m;}}
                
                List<SolicitudVinculacion> items = new ArrayList<>();

                for (SolicitudVinculacion e: r.getSolicitudes()) {
                    items.add(e);}
        
                Sector sector =  repo.getById(items.get(0).getSector().getId());
        
                sDTO.setName(sector.getOrganizacion().getRazonSocial());
                sDTO.setId(String.valueOf(sector.getOrganizacion().getId()));
                return json(sDTO); 
                       
                }
                case "ORGANIZACION":
                { 
                OrgDTO orgDTO = new OrgDTO();
                Organizacion org = new Organizacion();
                OrganizacionRepository repoO = new OrganizacionRepository();

                org = repoO.getByUser( (Integer.valueOf( input.getId() ) ) );
                orgDTO.setName(org.getRazonSocial());
                orgDTO.setId(String.valueOf(org.getId()));
                return json(orgDTO); 
                }
                
            
        }
        
        
        
        }
        catch(Exception exc){
            throw new Exception("In catch Exception geting the name of Organizacion");
        }
        return null; /// cambiarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr

    }

}