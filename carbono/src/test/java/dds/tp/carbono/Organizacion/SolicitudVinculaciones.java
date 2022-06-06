package dds.tp.carbono.Organizacion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.dao.org.SolicitudVinculacionDao;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.services.organizacion.SolicitadorDeVinculacion;
import lombok.Getter;
import lombok.Setter;

public class SolicitudVinculaciones {
    
    private MiembrosData dataMembers;
    private OrganizacionData dataOrg;

    @Before
    public void init() {
        String fileName = "miembros.json";
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) { 
            this.dataMembers = new Gson().fromJson(new InputStreamReader(is), MiembrosData.class);
        } catch (Exception ex) { }

        String fileName2 = "organizacion.json";
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName2)) {
            this.dataOrg = new Gson().fromJson(new InputStreamReader(is), OrganizacionData.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void solicitudDeVinculacion() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        Sector sector = this.getSectorRandom();
        solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);
        Assert.assertEquals(1, SolicitudVinculacionDao.getInstance().getAll().size());
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