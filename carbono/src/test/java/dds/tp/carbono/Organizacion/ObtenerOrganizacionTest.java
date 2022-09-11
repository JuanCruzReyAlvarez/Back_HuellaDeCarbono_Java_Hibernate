package dds.tp.carbono.Organizacion;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.utils.TestUtils;
import lombok.Getter;
import lombok.Setter;

public class ObtenerOrganizacionTest {

    private OrganizacionData dataOrg;

    @Before
    public void init() throws Exception {
        this.dataOrg = (OrganizacionData) TestUtils.readJson("organizacion.json", OrganizacionData.class);
    }

    @Test
    public void CrearOrganizacion() throws Exception {
        OrganizacionService creador = new OrganizacionService();

        Organizacion organizacion = this.getOrganizacionRandom();
        Sector sector = this.getSectorRandom();
        
        Organizacion organizacionCreada = creador.crear(organizacion); 

        Assert.assertNotNull(organizacionCreada.getId());
        Assert.assertFalse(organizacionCreada.getSectores().isEmpty());
        Assert.assertTrue(organizacionCreada.getSectores().contains(sector));
    }

    private Sector getSectorRandom() {
        return this.dataOrg.getOrganizaciones().get(0).getSectores().stream().collect(Collectors.toList()).get(0);
    }

    private Organizacion getOrganizacionRandom() {
        return this.dataOrg.getOrganizaciones().get(0);
    }

    private class OrganizacionData {
        @Getter @Setter private List<Organizacion> organizaciones;
    }
}

