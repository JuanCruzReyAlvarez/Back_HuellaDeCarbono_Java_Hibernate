package dds.tp.carbono.Organizacion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.services.organizacion.ContestadorDeSolicitudesVinculacion;
import dds.tp.carbono.services.organizacion.SolicitadorDeVinculacion;
import lombok.Getter;
import lombok.Setter;

public class ContestadorDeSolicitudesDeVinculacion {

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
    public void AceptadorDeSolicitud() throws Exception {
        SolicitadorDeVinculacion solicitador = new SolicitadorDeVinculacion();
        Sector sector = this.getSectorRandom();
        SolicitudVinculacion solicitud = solicitador.solicitarVinculacion(this.dataMembers.getMiembros().get(0), sector);


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