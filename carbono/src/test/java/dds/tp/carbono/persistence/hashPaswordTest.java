package dds.tp.carbono.persistence;




import org.junit.Test;


import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;


import dds.tp.carbono.entities.organization.Organizacion;

import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;

import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;

import dds.tp.carbono.repository.organization.OrganizacionRepository;

import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;






//import javax.persistence.EntityManager.createNativeQuery;

public class hashPaswordTest {


    /*@Test
    public void guardarConstraseñaHasheada(){
        Usuario user = new Usuario();
        UsuarioRepository repository = new UsuarioRepository();

        user.setUsername("Jero");
        user.setRol(Rol.ADMINISTRADOR);
        user.setHashPassword("stephy");

        repository.guardar(user);
    }*/


 
    @Test
    public void getOrg(){

        
         ProvinciaService provinciaService = new ProvinciaService();
        Provincia provincia = provinciaService.getById(2) ;    
        //OrganizacionService orgS = new OrganizacionService();
       
        SectorTerritorialRepository repo = new SectorTerritorialRepository();

        SectorTerritorial st = repo.getById(1);
        
        OrganizacionRepository dao = new OrganizacionRepository();

        Organizacion oorg = dao.getById(1);
        oorg.setRazonSocial("NUEVONOMBRE");
        oorg.setSectorTerritorial(st);

        dao.guardar(oorg);
        /*for (Organizacion o : oorg) {
        System.out.println("IMPRI");
        System.out.println(o.getRazonSocial());}


        
        for (Organizacion o : oorg){
            
             if(o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId().equals(provincia.getId())){
             Assert.assertEquals(Integer.valueOf(2), (o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId()));
                  orgRet.add(o);
            }
        }*/

       
        
    }

   /*  @Test
    public void guardar(){


        SolicitudVinculacion solicitud = new SolicitudVinculacion(); 
        solicitud.setId(1);
        solicitud.setEstado( EstadoSolicitudVinculacion.PENDIENTE);
        //no agregue sector ni miembrpo 

        EntityManagerHelper.beginTransaction();
        
        EntityManagerHelper.getEntityManager().persist(solicitud);
        
        EntityManagerHelper.commit();
       
        EntityManagerHelper.closeEntityManager();
        
    }*/

    @Test

    public void cargarListadoDeApi() throws Exception
    {

      AdminGeoInfoController controller = new AdminGeoInfoController();
        
      controller.refreshGeoInfoTEST();
 
 /*
       List <Localidad> localidadesArreglados = new ArrayList<>();
       List <Localidad> localidadOrg = new ArrayList<>();
       List <Municipio> municipios = new ArrayList<>();
       MunicipioRepository repo = new MunicipioRepository ();
       
       UbicacionesServicioExterno ubi= new UbicacionesServicioExterno();
       municipios = ubi.listadoDeMunicipios();
       System.out.println(municipios.get(0).getNombre());

       for (Municipio mun : municipios){
       //if(mun.getNombre()!="SIN INFORMAR"){ 
       localidadOrg = ubi.listadoDeLocalidades(mun);
   
           for(Localidad l : localidadOrg){
               
               System.out.println(l.getNombre());  
               System.out.println(l.getMunicipio().getNombre());

           }

           localidadesArreglados.removeAll(localidadesArreglados);
        //}
       }

     
 */


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
