package dds.tp.carbono.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import dds.tp.carbono.dao.EntityManagerHelper;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;
import dds.tp.carbono.repository.PuntoGeografico.MunicipioRepository;
import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.repository.auth.UsuarioRepository;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;
import dds.tp.carbono.services.ubicacion.UbicacionesCache;
import dds.tp.carbono.services.ubicacion.UbicacionesCacheDecorator;
import dds.tp.carbono.services.ubicacion.UbicacionesService;
import dds.tp.carbono.services.ubicacion.UbicacionesServicioExterno;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;





//import javax.persistence.EntityManager.createNativeQuery;

public class hashPaswordTest {


    @Test
    public void guardarConstraseñaHasheada(){
        Usuario user = new Usuario();
        UsuarioRepository repository = new UsuarioRepository();

        user.setUsername("Jero");
        user.setRol(Rol.ADMINISTRADOR);
        user.setHashPassword("stephy");

        repository.guardar(user);
    }


 
    @Test
    public void getOrg(){

            
        ProvinciaRepository repository = new ProvinciaRepository();
        List<Provincia> entidades = repository.getAll();
                  
        for(Provincia o :entidades ){
            System.out.println(o.getNombre());
        }

         
        
    }

    @Test
    public void guardar(){


        SolicitudVinculacion solicitud = new SolicitudVinculacion(); 
        solicitud.setId(1);
        solicitud.setEstado( EstadoSolicitudVinculacion.PENDIENTE);
        //no agregue sector ni miembrpo 

        EntityManagerHelper.beginTransaction();
        
        EntityManagerHelper.getEntityManager().persist(solicitud);
        
        EntityManagerHelper.commit();
       
        EntityManagerHelper.closeEntityManager();
        
    }

    @Test

    public void cargarListadoDeApi() throws Exception
    {



        AdminGeoInfoController controller = new AdminGeoInfoController();
        
        controller.refreshGeoInfoTEST();
/* 
        List <Localidad> localidadesArreglados = new ArrayList<>();
        List <Localidad> localidadOrg = new ArrayList<>();

        UbicacionesServicioExterno ubi= new UbicacionesServicioExterno();

        localidadOrg = ubi.listadoDeLocalidades();
            
            for(Localidad l : localidadOrg){

                Localidad loc = new Localidad();
                MunicipioRepository repo = new MunicipioRepository ();
                Municipio muni = new Municipio();

                //loc.setNombre(l.getNombre());   
               // System.out.println("localidad: " + l.getNombre());
                System.out.println("municipio: "+l.getMunicipio().getNombre());
                //muni.setId(repo.getIdByName(l.getMunicipio().getNombre()));  
                //loc.setMunicipio(muni);
                //localidadesArreglados.add(loc);
            }

*/



    }
}
