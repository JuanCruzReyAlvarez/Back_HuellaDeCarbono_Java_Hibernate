package dds.tp.carbono.persistence;




import java.util.ArrayList;
import java.util.List;


import org.junit.Test;


import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;
import dds.tp.carbono.repository.admin.TransporteNoMotorizadoRepository;
import dds.tp.carbono.repository.admin.TransporteParticularRepository;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;

import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.services.MiembroService;
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
    //NNNOOOO BBOORRAARRR------------------------------------------------
    @Test
    public void InicializateProyect() throws Exception   //NO BORRAR
    {

      AdminGeoInfoController controller = new AdminGeoInfoController();  
      controller.refreshGeoInfoTEST();

      TransporteNoMotorizadoRepository repositoryMedioNoMotorizado = new TransporteNoMotorizadoRepository();
      MedioNoMotorizado bicicleta = new MedioNoMotorizado();
      MedioNoMotorizado monopatin = new MedioNoMotorizado();
      MedioNoMotorizado pie = new MedioNoMotorizado();
      MedioNoMotorizado otro = new MedioNoMotorizado();

      bicicleta.setTipoMedioNoMotorizadoByString("BICICLETA");
      monopatin.setTipoMedioNoMotorizadoByString("MONOPATIN");
      pie.setTipoMedioNoMotorizadoByString("PIE");
      otro.setTipoMedioNoMotorizadoByString("OTRO");

      repositoryMedioNoMotorizado.guardar(bicicleta);
      repositoryMedioNoMotorizado.guardar(monopatin);
      repositoryMedioNoMotorizado.guardar(pie);
      repositoryMedioNoMotorizado.guardar(otro);

      TransporteParticularRepository transporteParticularRepository = new TransporteParticularRepository();
      
      VehiculoParticular auto1 = new VehiculoParticular(TipoVehiculoParticular.AUTO,TipoDeConsumo.Nafta);
      VehiculoParticular auto2 = new VehiculoParticular(TipoVehiculoParticular.AUTO,TipoDeConsumo.GNC);
      VehiculoParticular auto3 = new VehiculoParticular(TipoVehiculoParticular.AUTO,TipoDeConsumo.Diesel);
      VehiculoParticular auto4 = new VehiculoParticular(TipoVehiculoParticular.AUTO,TipoDeConsumo.Electricidad);
      VehiculoParticular auto5 = new VehiculoParticular(TipoVehiculoParticular.CAMIONETA,TipoDeConsumo.Nafta);
      VehiculoParticular auto6 = new VehiculoParticular(TipoVehiculoParticular.CAMIONETA,TipoDeConsumo.GNC);
      VehiculoParticular auto7 = new VehiculoParticular(TipoVehiculoParticular.CAMIONETA,TipoDeConsumo.Diesel);
      VehiculoParticular auto8 = new VehiculoParticular(TipoVehiculoParticular.CAMIONETA,TipoDeConsumo.Electricidad);
      VehiculoParticular auto9 = new VehiculoParticular(TipoVehiculoParticular.MOTO,TipoDeConsumo.Nafta);
      VehiculoParticular auto10 = new VehiculoParticular(TipoVehiculoParticular.MOTO,TipoDeConsumo.GNC);
      VehiculoParticular auto11 = new VehiculoParticular(TipoVehiculoParticular.MOTO,TipoDeConsumo.Diesel);
      VehiculoParticular auto12 = new VehiculoParticular(TipoVehiculoParticular.MOTO,TipoDeConsumo.Electricidad);

      transporteParticularRepository.guardar(auto1);
      transporteParticularRepository.guardar(auto2);
      transporteParticularRepository.guardar(auto3);
      transporteParticularRepository.guardar(auto4);
      transporteParticularRepository.guardar(auto5);
      transporteParticularRepository.guardar(auto6);
      transporteParticularRepository.guardar(auto7);
      transporteParticularRepository.guardar(auto8);
      transporteParticularRepository.guardar(auto9);
      transporteParticularRepository.guardar(auto10);
      transporteParticularRepository.guardar(auto11);
      transporteParticularRepository.guardar(auto12);

     }

    @Test

    public void buscarOrgPorIDUserMiembro() throws Exception
    {

        
        Miembro r = new Miembro();

        MiembroService ms = new MiembroService();

        List<Miembro> miembros =  ms.getAll(); 

        for (Miembro m:miembros   ){
            System.out.println(m.getNombre());
            if((m.getUser().getId()).equals(8) ){
                     r = m;
            }
            
        }

        List<SolicitudVinculacion> items = new ArrayList<>();
 
        // inserta cada elemento del conjunto en la lista
        for (SolicitudVinculacion e: r.getSolicitudes()) {
            items.add(e);
        }
     


        System.out.println( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println( r.getNombre());

        System.out.println(items.get(0).getId() + "id soli");
        System.out.println( items.get(0).getSector().getId()+ " id sector");

        
        SectorRepository repo = new SectorRepository();

        Sector sector =  repo.getById(items.get(0).getSector().getId());

        System.out.println(sector.getOrganizacion().getId() + "id org!!!!");
    }
        
        
      
}
