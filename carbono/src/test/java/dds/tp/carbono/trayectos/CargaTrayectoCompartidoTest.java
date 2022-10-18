/*package dds.tp.carbono.trayectos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.dao.member.TrayectoPendienteDao;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.TipoDocumento;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.member.TrayectoPendiente;
import dds.tp.carbono.entities.organization.Clasificacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.entities.organization.TipoOrganizacion;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoArbitrario;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoMedioNoMotorizado;
import dds.tp.carbono.entities.transport.TipoTransportePublico;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.TransportePublico;
import dds.tp.carbono.entities.transport.VehiculoParticular;
import dds.tp.carbono.services.miembro.trayecto.CreadorDeTrayecto;
import dds.tp.carbono.utils.TestUtils;
import lombok.Getter;
import lombok.Setter;

public class CargaTrayectoCompartidoTest {
    
    private ParadasData data;

    @Before
    public void init() throws Exception {
        this.data = (ParadasData) TestUtils.readJson("paradas.json", ParadasData.class);
    }

    @Test
    public void cargarTrayectoCompartido() throws Exception {
        Miembro yo = this.buildMiembro(1, "nombre1", "apellido1", TipoDocumento.DNI, "123456788");
        Miembro vos = this.buildMiembro(2, "nombre2", "apellido2", TipoDocumento.DNI, "123456789");

        PuntoArbitrario miCasa = this.buildMiCasa(); 
        Estacion paradaDeTuCasa = paradaDeTuCasa();
        PuntoArbitrario tuCasa = this.buildTuCasa(); 
        Organizacion utn = this.buildOrgUTN();
        
        Trayecto trayecto = new Trayecto(0);
        trayecto.setPuntoPartida(miCasa.getUbicacion());
        trayecto.setPuntoLlegada(utn.getUbicacion());

        trayecto.getTramos().add(crearTramo(miCasa.getUbicacion(), paradaDeTuCasa.getUbicacion(), this.getTransporteDeMiCasaATuCasa()));
        trayecto.getTramos().add(crearTramo(paradaDeTuCasa.getUbicacion(), tuCasa.getUbicacion(), new MedioNoMotorizado(1, TipoMedioNoMotorizado.PIE)));

        Tramo tramoCompartido = crearTramo(tuCasa.getUbicacion(), utn.getUbicacion(), this.getTransporteTuCasaAUtn());
        tramoCompartido.getCompartidos().add(vos);
        trayecto.getTramos().add(tramoCompartido);
        trayecto.setMiembro(yo);
        
        Trayecto trayectoCreado = new CreadorDeTrayecto(09).crear(trayecto);

        Assert.assertEquals(Integer.valueOf(1), trayectoCreado.getId());

        TrayectoPendiente trayectoPendiente = TrayectoPendienteDao.getInstance().getAll().get(0);

        Assert.assertNotNull(trayectoPendiente);
        Assert.assertEquals(1, trayectoPendiente.getMiembrosPendientes().size());
        Assert.assertEquals(vos, trayectoPendiente.getMiembrosPendientes().get(0));
    }


    private PuntoArbitrario buildTuCasa() {
        PuntoArbitrario tuCasa = new PuntoArbitrario();
        tuCasa.setUbicacion(this.buildPuntoGeografico(2, "verdadera", "456", 1));
        return tuCasa;
    }

    private PuntoArbitrario buildMiCasa() {
        PuntoArbitrario miCasa = new PuntoArbitrario();
        miCasa.setUbicacion(this.buildPuntoGeografico(1, "falsa", "123", 1));
        return miCasa;
    }

    private Organizacion buildOrgUTN() {
        return this.buildOrganizacion(
            "UTN", 
            this.buildPuntoGeografico(5, "Medrano", "951", 1), 
            TipoOrganizacion.INSTITUCION, 
            new Clasificacion(1, "Universidad"));
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
        tuAuto.setCombustible(TipoDeConsumo.Nafta);
        
        return tuAuto;
    }

    private Tramo crearTramo(PuntoGeografico pA, PuntoGeografico pB, MedioDeTransporte transporte) {
        Tramo tramo = new Tramo(0);
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
        Set<SolicitudVinculacion> solicitudes = new HashSet<SolicitudVinculacion>(); 
        organizacion.setRazonSocial(razonSocial);
        organizacion.setUbicacion(ubicacionUtn);
        organizacion.setTipo(tipo);
        organizacion.setClasificacion(clasificacion);
        organizacion.getSectores().add(new Sector(1, "Administrativo", organizacion,solicitudes));

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
*/