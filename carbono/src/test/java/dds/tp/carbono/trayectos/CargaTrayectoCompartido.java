package dds.tp.carbono.trayectos;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.TipoDocumento;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.member.TrayectoPendiente;
import dds.tp.carbono.entities.organization.Clasificacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.TipoOrganizacion;
import dds.tp.carbono.entities.point.PuntoArbitrario;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoCombustible;
import dds.tp.carbono.entities.transport.TipoMedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoTransportePublico;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.TransportePublico;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.repository.TrayectoPendienteRepository;
import dds.tp.carbono.services.miembro.trayecto.CreadorDeTrayecto;
import lombok.Getter;
import lombok.Setter;

public class CargaTrayectoCompartido {
    
    private ParadasData data;

    @Before
    public void init() {
        String fileName = "paradas.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.data = new Gson().fromJson(new InputStreamReader(is), ParadasData.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void cargarTrayectoCompartido() {
        Miembro yo = this.buildMiembro(1, "Leo", "Dan", TipoDocumento.DNI, "123456788");
        Miembro vos = this.buildMiembro(1, "Lucas", "Piola", TipoDocumento.DNI, "123456789");

        PuntoArbitrario miCasa = new PuntoArbitrario();
        miCasa.setUbicacion(this.buildPuntoGeografico(1, "falsa", "123", 1));

        Estacion paradaDeTuCasa = paradaDeTuCasa();

        PuntoArbitrario tuCasa = new PuntoArbitrario();
        tuCasa.setUbicacion(this.buildPuntoGeografico(2, "verdadera", "456", 1));

        PuntoGeografico ubicacionUtn = this.buildPuntoGeografico(5, "Medrano", "951", 1);
        Clasificacion clasificacion = new Clasificacion(1, "Universidad");
        Organizacion utn = this.buildOrganizacion("UTN", ubicacionUtn, TipoOrganizacion.INSTITUCION, clasificacion);
        
        utn.getSectores().add(new Sector(1, "Administrativo", utn));
        utn.getSectores().add(new Sector(2, "Directivo", utn));
        utn.getSectores().add(new Sector(3, "Alumnos", utn));
        utn.getSectores().add(new Sector(4, "Profesores", utn));
        
        Trayecto trayecto = new Trayecto();
        trayecto.setPuntoPartida(miCasa.getUbicacion());
        trayecto.setPuntoLlegada(utn.getUbicacion());

        trayecto.getTramos().add(crearTramo(miCasa.getUbicacion(), paradaDeTuCasa.getUbicacion(), this.getTransporteDeMiCasaATuCasa()));
        trayecto.getTramos().add(crearTramo(paradaDeTuCasa.getUbicacion(), tuCasa.getUbicacion(), new MedioNoMotorizado(1, TipoMedioNoMotorizado.PIE)));

        Tramo tramoCompartido = crearTramo(tuCasa.getUbicacion(), utn.getUbicacion(), this.getTransporteTuCasaAUtn());
        tramoCompartido.getCompartidos().add(vos);
        trayecto.getTramos().add(tramoCompartido);
        trayecto.setMiembro(yo);
        
        CreadorDeTrayecto creadorTrayecto = new CreadorDeTrayecto();
       
        Trayecto trayectoCreado = creadorTrayecto.crear(trayecto);

        Assert.assertEquals(Integer.valueOf(1), trayectoCreado.getId());

        TrayectoPendiente trayectoPendiente = TrayectoPendienteRepository.getInstance().getAll().get(0);

        Assert.assertNotNull(trayectoPendiente);
        Assert.assertEquals(1, trayectoPendiente.getMiembrosPendientes().size());
        Assert.assertEquals(vos, trayectoPendiente.getMiembrosPendientes().get(0));
    }


    private Miembro buildMiembro(Integer id, String nombre, String apellido, TipoDocumento tipoDocumento, String nroDocumento) {
        Miembro miembro = new Miembro();
        miembro.setId(id);
        miembro.setNombre(nombre);
        miembro.setApellido(apellido);
        miembro.setTipoDocumento(TipoDocumento.DNI);
        miembro.setNroDocumento(nroDocumento);

        return miembro;
    }

    private MedioDeTransporte getTransporteTuCasaAUtn() {
        VehiculoParticular tuAuto = new VehiculoParticular();
        tuAuto.setTipo(TipoVehiculoParticular.AUTO);
        tuAuto.setId(1);
        tuAuto.setCombustible(TipoCombustible.NAFTA);
        
        return tuAuto;
    }

    private Tramo crearTramo(PuntoGeografico pA, PuntoGeografico pB, MedioDeTransporte transporte) {
        Tramo tramo = new Tramo();
        tramo.setPuntoA(pA);
        tramo.setPuntoB(pB);
        tramo.setTransporte(transporte);
        return tramo;
    }

    private Estacion paradaDeTuCasa() {
        List<Estacion> paradas = this.data.getLineas().get(0).getEstaciones();
        return paradas.get(paradas.size() -1);
    }

    private MedioDeTransporte getTransporteDeMiCasaATuCasa() {
        TransportePublico bondi = new TransportePublico();
        bondi.setId(1);
        bondi.setTipo(TipoTransportePublico.COLECTIVO);
        bondi.setLinea(this.data.getLineas().get(0));

        return bondi;
    }


    private Organizacion buildOrganizacion(String razonSocial, PuntoGeografico ubicacionUtn, TipoOrganizacion tipo, Clasificacion clasificacion) {
        Organizacion organizacion = new Organizacion();
        organizacion.setRazonSocial(razonSocial);
        organizacion.setUbicacion(ubicacionUtn);
        organizacion.setTipo(tipo);
        organizacion.setClasificacion(clasificacion);
        return organizacion;
    }

    private PuntoGeografico buildPuntoGeografico(int id, String calle, String altura, int localidadId) {
        PuntoGeografico punto = new PuntoGeografico();
        punto.setId(id);
        punto.setCalle(calle);
        punto.setAltura(altura);
        punto.setIdLocalidad(localidadId);

        return punto;
    }

    private class ParadasData {
        @Getter @Setter private List<Linea> lineas;
    }
}
