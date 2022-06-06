package dds.tp.carbono.Organizacion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;


import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import lombok.Getter;
import lombok.Setter;

public class ObtenerOrganizacion {

    private OrganizacionData data = null;

    @Before
    public void init() {
        String fileName = "organizacion.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {  //preguntar
            this.data = new Gson().fromJson(new InputStreamReader(is), OrganizacionData.class); 
        } catch (Exception ex) {                                                                         
            System.out.println(ex.getMessage());
        }
    }

    /* 
    @Test
        public void sectores_organizacion() throws Exception {
        Organizacion organizacion  = new Organizacion();
         organizacion.setRazonSocial("Motorola");
        
         Sector sector_uno = this.buildSector(1, "Programador");
         Sector sector_dos= this.buildSector(2, "Analista Universitario");
         Sector sector_tres = this.buildSector(3, "Data Scientist");
        
         Set<Sector> sectores = new HashSet<Sector>();
         sectores.add(sector_uno);
         sectores.add(sector_dos);
         sectores.add(sector_tres);

         organizacion.setSectores(sectores);

         Assert.assertEquals(organizacion.getSectores().size(), 3);
     }

*/


          
    private int organizacionEjemplo() {
        List<Organizacion> organizaciones = this.data.getOrganizaciones();
        Set<Sector> sectores = organizaciones.get(0).getSectores();
        return sectores.size();
    }

    private Sector buildSector(int id, String nombre) {
        Sector punto = new Sector();
        punto.setId(id);
        punto.setNombre(nombre);
        return punto;
    }

    private class OrganizacionData {
        @Getter @Setter private List<Organizacion> organizaciones;
    }
}

    // @Test
    // public int distanciaTransportePublico2() throws Exception {
    //     Tramo tramo = new Tramo();
    //     tramo.setId(1);

    //     Sector sector_uno = this.buildSector(1, "Programador");
    //     Sector sector_dos= this.buildSector(2, "Data Scientist");
    //     Sector sector_tres = this.buildSector(3, "Desarrollador web");
    //     Sector sector_cuatro = this.buildSector(4, "Analista");

    //     Set<Sector> sectores = new HashSet<Sector>();
    //     sectores.add(sector_uno);
    //     sectores.add(sector_dos);
    //     sectores.add(sector_tres);
    //     sectores.add(sector_cuatro);

        
    // } 