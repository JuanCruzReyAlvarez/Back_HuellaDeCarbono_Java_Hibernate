package dds.tp.carbono.Organizacion;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.dao.org.SolicitudVinculacionDao;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.services.miembro.SolicitadorDeVinculacion;
import dds.tp.carbono.utils.TestUtils;
import lombok.Getter;
import lombok.Setter;

public class SolicitudVinculacionesTest {
    
    private MiembrosData dataMembers;
    private OrganizacionData dataOrg;

    @Before
    public void init() throws Exception {
        this.dataMembers = (MiembrosData) TestUtils.readJson("miembros.json", MiembrosData.class);
        this.dataOrg = (OrganizacionData) TestUtils.readJson("organizacion.json", OrganizacionData.class);
    }

    @Test
    public void solicitudDeVinculacion() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        
        Sector sector = this.getSectorRandom();
        Miembro miembro = this.getMiembroRandom();
        
        solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);
        Assert.assertTrue(SolicitudVinculacionDao.getInstance().getAll()
                                                               .stream()
                                                               .anyMatch(s -> s.getMiembro()
                                                                               .getNroDocumento()
                                                                               .equals(miembro.getNroDocumento())));
    }

    @Test
    public void solicitudDeVinculacionExistente() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        Sector sector = this.getSectorRandom();
        solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);

        try {
            SolicitudVinculacion solicitud2 = solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);
            Assert.assertNull(solicitud2);
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    private Miembro getMiembroRandom() {
        return this.dataMembers.getMiembros().get(0);
    }

    private Sector getSectorRandom() {
        return this.dataOrg.getOrganizaciones().get(0).getSectores().stream().collect(Collectors.toList()).get(0);
    }

    private class MiembrosData {
        @Getter @Setter private List<Miembro> miembros;
    }

    private class OrganizacionData {
        @Getter @Setter private List<Organizacion> organizaciones;
    }

}