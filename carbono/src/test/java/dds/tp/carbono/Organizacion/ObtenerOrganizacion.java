package dds.tp.carbono.Organizacion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.services.organizacion.CreadorDeOrganizacion;

import lombok.Getter;
import lombok.Setter;

public class ObtenerOrganizacion {

    //private MiembrosData dataMembers;
    private OrganizacionData dataOrg;

    @Before
    public void init() {
        String fileName = "organizacion.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) { 
            this.dataOrg = new Gson().fromJson(new InputStreamReader(is), OrganizacionData.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void CrearOrganizacion() throws Exception {

        CreadorDeOrganizacion creador = new CreadorDeOrganizacion();
        Organizacion organizacion = this.getOrganizacionRandom();
        Sector sector = this.getSectorRandom();
        
        Set<Sector> sectores = new HashSet<Sector>(); 

        Organizacion organizacionCreada = creador.crear(organizacion); 

        Assert.assertFalse(organizacionCreada.getSectores().isEmpty());
        
        sectores.add(sector);

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

