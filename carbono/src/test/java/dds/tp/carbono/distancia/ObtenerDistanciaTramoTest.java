package dds.tp.carbono.distancia;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.Estacion;
import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.ServicioContratado;
import dds.tp.carbono.entities.transport.TipoTransportePublico;
import dds.tp.carbono.entities.transport.TransportePublico;
import lombok.Getter;
import lombok.Setter;

public class ObtenerDistanciaTramoTest {

    private ParadasData data = null;

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
    public void distanciaTransportePublico() throws Exception {
        Tramo tramo = new Tramo();
        tramo.setId(1);

        PuntoGeografico origen = this.buildPuntoGeografico(1, "cordoba", "1500", 1);
        PuntoGeografico destino = this.buildPuntoGeografico(4, "cordoba", "3000", 1);
        TransportePublico transporte = this.buildTransportePublico(1, TipoTransportePublico.SUBTE, 0);

        tramo.setPuntoA(origen);
        tramo.setPuntoB(destino);
        tramo.setTransporte(transporte);

        Assert.assertEquals(Double.valueOf(1500.93), tramo.obtenerDistancia());
    }

    @Test
    public void distanciaTransportePublico2() throws Exception {
        Tramo tramo = new Tramo();
        tramo.setId(1);

        PuntoGeografico origen = this.buildPuntoGeografico(1, "cordoba", "1500", 1);
        PuntoGeografico destino = this.buildPuntoGeografico(3, "cordoba", "3000", 1);
        TransportePublico subte = this.buildTransportePublico(1, TipoTransportePublico.SUBTE, 0);

        tramo.setPuntoA(origen);
        tramo.setPuntoB(destino);
        tramo.setTransporte(subte);

        Assert.assertEquals(Double.valueOf(1000.7), tramo.obtenerDistancia());
    }

    @Test
    public void distanciaServicioContratado() throws Exception {
        Tramo tramo = new Tramo();

        PuntoGeografico origen = this.buildPuntoGeografico(1, "cordoba", "1500", 1);
        PuntoGeografico destino = this.buildPuntoGeografico(3, "cordoba", "3000", 1);

        tramo.setId(1);
        tramo.setPuntoA(origen);
        tramo.setPuntoB(destino);
        tramo.setTransporte(new ServicioContratado());
       
        Double distancia = tramo.obtenerDistancia();

        System.out.println(distancia);

        Assert.assertNotNull(distancia);
    }

    private TransportePublico buildTransportePublico(int id, TipoTransportePublico tipo, int lineaIndex) {
        TransportePublico transporte = new TransportePublico();
        transporte.setId(id);
        transporte.setTipo(tipo);
        transporte.setLinea(this.buildLinea(lineaIndex));

        return transporte;
    }

    private Linea buildLinea(int lineaIndex) {
        Linea linea = this.data.getLineas().get(lineaIndex);

        for (int i = 0; i < linea.getEstaciones().size(); i++) {
            Estacion siguiente = null;
            if (i < linea.getEstaciones().size() - 1)
                siguiente = linea.getEstaciones().get(i + 1);
            
            linea.getEstaciones().get(i).setSiguiente(siguiente);
        }

        return linea;
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
