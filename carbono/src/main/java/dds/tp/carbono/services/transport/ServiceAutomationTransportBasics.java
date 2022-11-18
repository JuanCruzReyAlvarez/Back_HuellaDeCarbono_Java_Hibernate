package dds.tp.carbono.services.transport;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.repository.PuntoGeografico.PuntoGeograficoRepository;
import dds.tp.carbono.repository.admin.LineaRepository;
import dds.tp.carbono.repository.admin.TransporteNoMotorizadoRepository;
import dds.tp.carbono.repository.admin.TransporteParticularRepository;

public class ServiceAutomationTransportBasics {

    public void execute() {

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


        List<Estacion> estacioness= new ArrayList<Estacion>();


        PuntoGeografico cuatrow = new PuntoGeografico("1616", "1616", 1546);
        PuntoGeografico tresw = new PuntoGeografico("1515", "1515", 1546);
        PuntoGeografico dosw = new PuntoGeografico("1414", "1414", 1566);
        PuntoGeografico unow = new PuntoGeografico("1313", "1313", 1566);
  
        puntoGeograficoRepository.saveOne(cuatrow);
        puntoGeograficoRepository.saveOne(tresw);
        puntoGeograficoRepository.saveOne(dosw);
        puntoGeograficoRepository.saveOne(unow);
        
        Estacion estacion1w = new Estacion();
        Estacion estacion2w = new Estacion();
        Estacion estacion3w = new Estacion();
        Estacion estacion4w = new Estacion();
  
        estacion4w.setNombre("Martinez");
        estacion4w.setSiguiente(null);
        estacion4w.setUbicacion(cuatro); //Localidad El Juncal
        estacion4w.setDistanciaEstacionAnterior(40);
        
        estacion3w.setNombre("San Isidro");
        estacion3w.setSiguiente(estacion4);
        estacion3w.setUbicacion(tres); //Localidad El Juncal
        estacion3w.setDistanciaEstacionAnterior(40);
        
        estacion2w.setNombre("Beccar");
        estacion2w.setSiguiente(estacion3);
        estacion2w.setUbicacion(dos); //Localidad Guardia Mitre
        estacion2w.setDistanciaEstacionAnterior(40);
  
        estacion1w.setNombre("Victoria");
        estacion1w.setSiguiente(estacion2);
        estacion1w.setUbicacion(uno); //Localidad Guardia Mitre
        estacion1w.setDistanciaEstacionAnterior(40);
  
  
        estacioness.add(estacion4w);
        estacioness.add(estacion3w);
        estacioness.add(estacion2w);
        estacioness.add(estacion1w);
  
        Linea lineaa = new Linea();
  
        lineaa.setEstaciones(estacioness);
        lineaa.setNombre("202");
        
  
        lineaRepository.save(lineaa);








        List<Estacion> estacionesqq= new ArrayList<Estacion>();


        PuntoGeografico cuatroq = new PuntoGeografico("1212", "1212", 1546);
        PuntoGeografico tresq = new PuntoGeografico("1111", "1111", 1546);
        PuntoGeografico dosq = new PuntoGeografico("1010", "1010", 1566);
        PuntoGeografico unoq = new PuntoGeografico("9999", "9999", 1566);
  

        puntoGeograficoRepository.saveOne(cuatroq);
        puntoGeograficoRepository.saveOne(tresq);
        puntoGeograficoRepository.saveOne(dosq);
        puntoGeograficoRepository.saveOne(unoq);
        
        Estacion estacion1q = new Estacion();
        Estacion estacion2q = new Estacion();
        Estacion estacion3q = new Estacion();
        Estacion estacion4q = new Estacion();
  
        estacion4q.setNombre("Martinez");
        estacion4q.setSiguiente(null);
        estacion4q.setUbicacion(cuatro); //Localidad El Juncal
        estacion4q.setDistanciaEstacionAnterior(40);
        
        estacion3q.setNombre("San Isidro");
        estacion3q.setSiguiente(estacion4);
        estacion3q.setUbicacion(tres); //Localidad El Juncal
        estacion3q.setDistanciaEstacionAnterior(40);
        
        estacion2q.setNombre("Beccar");
        estacion2q.setSiguiente(estacion3);
        estacion2q.setUbicacion(dos); //Localidad Guardia Mitre
        estacion2q.setDistanciaEstacionAnterior(40);
  
        estacion1q.setNombre("Victoria");
        estacion1q.setSiguiente(estacion2);
        estacion1q.setUbicacion(uno); //Localidad Guardia Mitre
        estacion1q.setDistanciaEstacionAnterior(40);
  
  
        estacionesqq.add(estacion4q);
        estacionesqq.add(estacion3q);
        estacionesqq.add(estacion2q);
        estacionesqq.add(estacion1q);
  
        Linea lineaqq = new Linea();
  
        lineaqq.setEstaciones(estacionesqq);
        lineaqq.setNombre("365");
        
  
        lineaRepository.save(lineaqq);





        List<Estacion> estacioneszz= new ArrayList<Estacion>();



        PuntoGeografico cuatrozz = new PuntoGeografico("8888", "8888", 1546);
        PuntoGeografico treszz = new PuntoGeografico("7777", "7777", 1546);
        PuntoGeografico doszz = new PuntoGeografico("6666", "6666", 1566);
        PuntoGeografico unozz = new PuntoGeografico("5555", "5555", 1566);
  

        puntoGeograficoRepository.saveOne(cuatrozz);
        puntoGeograficoRepository.saveOne(treszz);
        puntoGeograficoRepository.saveOne(doszz);
        puntoGeograficoRepository.saveOne(unozz);
        
        Estacion estacion1zz = new Estacion();
        Estacion estacion2zz = new Estacion();
        Estacion estacion3zz = new Estacion();
        Estacion estacion4zz = new Estacion();
  
        estacion4zz.setNombre("UTN");
        estacion4zz.setSiguiente(null);
        estacion4zz.setUbicacion(cuatro); 
        estacion4zz.setDistanciaEstacionAnterior(40);
        
        estacion3zz.setNombre("Deportivo Español");
        estacion3zz.setSiguiente(estacion4);
        estacion3zz.setUbicacion(tres); 
        estacion3zz.setDistanciaEstacionAnterior(40);
        
        estacion2zz.setNombre("Facultad de Medicina UBA");
        estacion2zz.setSiguiente(estacion3);
        estacion2zz.setUbicacion(dos); 
        estacion2zz.setDistanciaEstacionAnterior(40);
  
        estacion1zz.setNombre("Retiro");
        estacion1zz.setSiguiente(estacion2);
        estacion1zz.setUbicacion(uno); 
        estacion1zz.setDistanciaEstacionAnterior(40);
  
  
        estacioneszz.add(estacion4);
        estacioneszz.add(estacion3);
        estacioneszz.add(estacion2);
        estacioneszz.add(estacion1);
  
        Linea lineazz = new Linea();
  
        lineazz.setEstaciones(estacioneszz);
        lineazz.setNombre("7");
        
  
        lineaRepository.save(lineazz);
  


    }
    
}
