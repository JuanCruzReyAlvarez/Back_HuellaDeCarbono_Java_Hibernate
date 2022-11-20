/* 
package dds.tp.carbono.persistence;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.http.controllers.admin.AdminGeoInfoController;
import dds.tp.carbono.repository.PuntoGeografico.PuntoGeograficoRepository;
import dds.tp.carbono.repository.admin.LineaRepository;
import dds.tp.carbono.repository.admin.TransporteNoMotorizadoRepository;
import dds.tp.carbono.repository.admin.TransporteParticularRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.services.MiembroService;





*/

//import javax.persistence.EntityManager.createNativeQuery;

//public class hashPaswordTest {


    /*@Test
    public void guardarConstraseñaHasheada(){
        Usuario user = new Usuario();
        UsuarioRepository repository = new UsuarioRepository();

        user.setUsername("Jero");
        user.setRol(Rol.ADMINISTRADOR);
        user.setHashPassword("stephy");

        repository.guardar(user);
    }*/


 /* 
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
        */
        /*for (Organizacion o : oorg) {
        System.out.println("IMPRI");
        System.out.println(o.getRazonSocial());}


        
        for (Organizacion o : oorg){
            
             if(o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId().equals(provincia.getId())){
             Assert.assertEquals(Integer.valueOf(2), (o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId()));
                  orgRet.add(o);
            }
        }
        
        
     }
        
        */

       
        


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
    /* 
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
     public void LineaCreator60() throws Exception
     {

        List<Estacion> estaciones= new ArrayList<Estacion>();



        PuntoGeografico cuatro = new PuntoGeografico("4444", "4444", 1546);// EL JUNCAL
        PuntoGeografico tres = new PuntoGeografico("3333", "3333", 1546);  // EL JUCAL 
        PuntoGeografico dos = new PuntoGeografico("2222", "2222", 1566);   // GUARDIA MITRE
        PuntoGeografico uno = new PuntoGeografico("1111", "1111", 1566);   // GUARDIA MITRE
  
        PuntoGeograficoRepository puntoGeograficoRepository = new PuntoGeograficoRepository();
        puntoGeograficoRepository.saveOne(cuatro);
        puntoGeograficoRepository.saveOne(tres);
        puntoGeograficoRepository.saveOne(dos);
        puntoGeograficoRepository.saveOne(uno);
        
        Estacion estacion1 = new Estacion();
        Estacion estacion2 = new Estacion();
        Estacion estacion3 = new Estacion();
        Estacion estacion4 = new Estacion();
  
        estacion4.setNombre("Martinez");
        estacion4.setSiguiente(null);
        estacion4.setUbicacion(cuatro); //Localidad El Juncal
        estacion4.setDistanciaEstacionAnterior(40);
        
        estacion3.setNombre("San Isidro");
        estacion3.setSiguiente(estacion4);
        estacion3.setUbicacion(tres); //Localidad El Juncal
        estacion3.setDistanciaEstacionAnterior(40);
        
        estacion2.setNombre("Beccar");
        estacion2.setSiguiente(estacion3);
        estacion2.setUbicacion(dos); //Localidad Guardia Mitre
        estacion2.setDistanciaEstacionAnterior(40);
  
        estacion1.setNombre("Victoria");
        estacion1.setSiguiente(estacion2);
        estacion1.setUbicacion(uno); //Localidad Guardia Mitre
        estacion1.setDistanciaEstacionAnterior(40);
  
  
        estaciones.add(estacion4);
        estaciones.add(estacion3);
        estaciones.add(estacion2);
        estaciones.add(estacion1);
  
        Linea linea = new Linea();
  
        linea.setEstaciones(estaciones);
        linea.setNombre("60");
        
  
        LineaRepository lineaRepository = new LineaRepository();
  
        lineaRepository.save(linea);
  

     }

     @Test
     public void LineaCreator202() throws Exception
     {

        List<Estacion> estaciones= new ArrayList<Estacion>();



        PuntoGeografico cuatro = new PuntoGeografico("1616", "1616", 1546);
        PuntoGeografico tres = new PuntoGeografico("1515", "1515", 1546);
        PuntoGeografico dos = new PuntoGeografico("1414", "1414", 1566);
        PuntoGeografico uno = new PuntoGeografico("1313", "1313", 1566);
  
        PuntoGeograficoRepository puntoGeograficoRepository = new PuntoGeograficoRepository();
        puntoGeograficoRepository.saveOne(cuatro);
        puntoGeograficoRepository.saveOne(tres);
        puntoGeograficoRepository.saveOne(dos);
        puntoGeograficoRepository.saveOne(uno);
        
        Estacion estacion1 = new Estacion();
        Estacion estacion2 = new Estacion();
        Estacion estacion3 = new Estacion();
        Estacion estacion4 = new Estacion();
  
        estacion4.setNombre("Martinez");
        estacion4.setSiguiente(null);
        estacion4.setUbicacion(cuatro); //Localidad El Juncal
        estacion4.setDistanciaEstacionAnterior(40);
        
        estacion3.setNombre("San Isidro");
        estacion3.setSiguiente(estacion4);
        estacion3.setUbicacion(tres); //Localidad El Juncal
        estacion3.setDistanciaEstacionAnterior(40);
        
        estacion2.setNombre("Beccar");
        estacion2.setSiguiente(estacion3);
        estacion2.setUbicacion(dos); //Localidad Guardia Mitre
        estacion2.setDistanciaEstacionAnterior(40);
  
        estacion1.setNombre("Victoria");
        estacion1.setSiguiente(estacion2);
        estacion1.setUbicacion(uno); //Localidad Guardia Mitre
        estacion1.setDistanciaEstacionAnterior(40);
  
  
        estaciones.add(estacion4);
        estaciones.add(estacion3);
        estaciones.add(estacion2);
        estaciones.add(estacion1);
  
        Linea linea = new Linea();
  
        linea.setEstaciones(estaciones);
        linea.setNombre("202");
        
  
        LineaRepository lineaRepository = new LineaRepository();
  
        lineaRepository.save(linea);
  

     }
     @Test
     public void LineaCreator365() throws Exception
     {

        List<Estacion> estaciones= new ArrayList<Estacion>();



        PuntoGeografico cuatro = new PuntoGeografico("1212", "1212", 1546);
        PuntoGeografico tres = new PuntoGeografico("1111", "1111", 1546);
        PuntoGeografico dos = new PuntoGeografico("1010", "1010", 1566);
        PuntoGeografico uno = new PuntoGeografico("9999", "9999", 1566);
  
        PuntoGeograficoRepository puntoGeograficoRepository = new PuntoGeograficoRepository();
        puntoGeograficoRepository.saveOne(cuatro);
        puntoGeograficoRepository.saveOne(tres);
        puntoGeograficoRepository.saveOne(dos);
        puntoGeograficoRepository.saveOne(uno);
        
        Estacion estacion1 = new Estacion();
        Estacion estacion2 = new Estacion();
        Estacion estacion3 = new Estacion();
        Estacion estacion4 = new Estacion();
  
        estacion4.setNombre("Martinez");
        estacion4.setSiguiente(null);
        estacion4.setUbicacion(cuatro); //Localidad El Juncal
        estacion4.setDistanciaEstacionAnterior(40);
        
        estacion3.setNombre("San Isidro");
        estacion3.setSiguiente(estacion4);
        estacion3.setUbicacion(tres); //Localidad El Juncal
        estacion3.setDistanciaEstacionAnterior(40);
        
        estacion2.setNombre("Beccar");
        estacion2.setSiguiente(estacion3);
        estacion2.setUbicacion(dos); //Localidad Guardia Mitre
        estacion2.setDistanciaEstacionAnterior(40);
  
        estacion1.setNombre("Victoria");
        estacion1.setSiguiente(estacion2);
        estacion1.setUbicacion(uno); //Localidad Guardia Mitre
        estacion1.setDistanciaEstacionAnterior(40);
  
  
        estaciones.add(estacion4);
        estaciones.add(estacion3);
        estaciones.add(estacion2);
        estaciones.add(estacion1);
  
        Linea linea = new Linea();
  
        linea.setEstaciones(estaciones);
        linea.setNombre("365");
        
  
        LineaRepository lineaRepository = new LineaRepository();
  
        lineaRepository.save(linea);
  

     }

     @Test
     public void LineaCreator7() throws Exception
     {

        List<Estacion> estaciones= new ArrayList<Estacion>();



        PuntoGeografico cuatro = new PuntoGeografico("8888", "8888", 1546);
        PuntoGeografico tres = new PuntoGeografico("7777", "7777", 1546);
        PuntoGeografico dos = new PuntoGeografico("6666", "6666", 1566);
        PuntoGeografico uno = new PuntoGeografico("5555", "5555", 1566);
  
        PuntoGeograficoRepository puntoGeograficoRepository = new PuntoGeograficoRepository();
        puntoGeograficoRepository.saveOne(cuatro);
        puntoGeograficoRepository.saveOne(tres);
        puntoGeograficoRepository.saveOne(dos);
        puntoGeograficoRepository.saveOne(uno);
        
        Estacion estacion1 = new Estacion();
        Estacion estacion2 = new Estacion();
        Estacion estacion3 = new Estacion();
        Estacion estacion4 = new Estacion();
  
        estacion4.setNombre("UTN");
        estacion4.setSiguiente(null);
        estacion4.setUbicacion(cuatro); 
        estacion4.setDistanciaEstacionAnterior(40);
        
        estacion3.setNombre("Deportivo Español");
        estacion3.setSiguiente(estacion4);
        estacion3.setUbicacion(tres); 
        estacion3.setDistanciaEstacionAnterior(40);
        
        estacion2.setNombre("Facultad de Medicina UBA");
        estacion2.setSiguiente(estacion3);
        estacion2.setUbicacion(dos); 
        estacion2.setDistanciaEstacionAnterior(40);
  
        estacion1.setNombre("Retiro");
        estacion1.setSiguiente(estacion2);
        estacion1.setUbicacion(uno); 
        estacion1.setDistanciaEstacionAnterior(40);
  
  
        estaciones.add(estacion4);
        estaciones.add(estacion3);
        estaciones.add(estacion2);
        estaciones.add(estacion1);
  
        Linea linea = new Linea();
  
        linea.setEstaciones(estaciones);
        linea.setNombre("7");
        
  
        LineaRepository lineaRepository = new LineaRepository();
  
        lineaRepository.save(linea);
  

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
*/
