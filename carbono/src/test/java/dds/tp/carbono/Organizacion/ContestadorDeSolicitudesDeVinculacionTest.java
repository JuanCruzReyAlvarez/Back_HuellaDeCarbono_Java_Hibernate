/*package dds.tp.carbono.Organizacion;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.services.miembro.SolicitadorDeVinculacion;
import dds.tp.carbono.services.organizacion.ContestadorDeSolicitudesVinculacion;
import dds.tp.carbono.utils.TestUtils;
import lombok.Getter;
import lombok.Setter;

public class ContestadorDeSolicitudesDeVinculacionTest {

    private MiembrosData dataMembers;
    private OrganizacionData dataOrg;

    @Before
    public void init() throws Exception {
        this.dataMembers = (MiembrosData) TestUtils.readJson("miembros.json", MiembrosData.class);
        this.dataOrg = (OrganizacionData) TestUtils.readJson("organizacion.json", OrganizacionData.class);
    }
    
    @Test
    public void AceptadorDeSolicitud() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        Sector sector = this.getSectorRandom();
        Miembro miembro = this.getMiembroRandom();
        
        SolicitudVinculacion solicitud = solicitador.solicitarVinculacion(miembro, sector);

        ContestadorDeSolicitudesVinculacion contestador = new ContestadorDeSolicitudesVinculacion(); 
        SolicitudVinculacion solicitudAceptada = contestador.aceptar(solicitud);

        try {
            SolicitudVinculacion solicitudAceptada2 = contestador.aceptar(solicitud);
            Assert.assertNull(solicitudAceptada2);
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
        
        Assert.assertEquals(EstadoSolicitudVinculacion.ACEPTADO, solicitudAceptada.getEstado());
    }

    @Test
    public void RechazadorDeSolicitud() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        Sector sector = this.getSectorRandom();
        SolicitudVinculacion solicitud = solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);
        
        ContestadorDeSolicitudesVinculacion contestador = new ContestadorDeSolicitudesVinculacion();
        SolicitudVinculacion solicitudRechazada = contestador.rechazar(solicitud);
       
        try {
            SolicitudVinculacion solicitudRechazada2 = contestador.rechazar(solicitud);
            Assert.assertNull(solicitudRechazada2);
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
        
         Assert.assertEquals(EstadoSolicitudVinculacion.RECHAZADO, solicitudRechazada.getEstado());
    }

    private Miembro getMiembroRandom() {
        return this.dataMembers.getMiembros().get(0);
    }

    private Sector getSectorRandom() {
        return this.dataOrg.getOrganizaciones()
                           .get(0)
                           .getSectores()
                           .stream()
                           .collect(Collectors.toList())
                           .get(0);
    }

    private class MiembrosData {
        @Getter @Setter private List<Miembro> miembros;
    }

    private class OrganizacionData {
        @Getter @Setter private List<Organizacion> organizaciones;
    }
}*/