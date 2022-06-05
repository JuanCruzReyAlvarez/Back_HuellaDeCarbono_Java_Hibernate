package dds.tp.carbono.distancia;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.*;
import dds.tp.carbono.entities.transport.calculator.CalculadorTransportePublico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.Getter;
import lombok.Setter;

public class DistanciaTramo {

    private ParadasData data = null;
    @Before
    public void init() {
        String fileName = "paradas.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.data = new Gson().fromJson(new InputStreamReader(is), ParadasData.class);
        } catch (Exception ex) { }
    }

    @Test
    public void distanciaAnterior() {

        this.data.getLineas().stream().forEach((Linea linea) -> { 
            System.out.println("Linea: " + linea.getNombre()); 
            System.out.println("Estaciones"); 
            linea.getEstaciones().stream().forEach((Estacion estacion) -> {
                System.out.println(String.format("%d: %s - Distancia Anterior: %f", estacion.getId(), estacion.getUbicacion().getDireccion(), estacion.getDistanciaEstacionAnterior()));
            });
        });

    }
    @Test
    public void distanciaTramo() throws Exception {

        Tramo tramoDePrueba = new Tramo();
        tramoDePrueba.setId(1);

        PuntoGeografico origen = new PuntoGeografico();
        origen.setId(1);
        origen.setDireccion("cordoba 1500");

        PuntoGeografico destino = new PuntoGeografico();
        destino.setId(4);
        destino.setDireccion("cordoba 3000");

        CalculadorTransportePublico calculador = new CalculadorTransportePublico();

        TransportePublico transporte = new TransportePublico();
        transporte.setId(1);
        transporte.setTipo(TipoTransportePublico.SUBTE);
        transporte.setCalculador(calculador);
        Linea lineaDePrueba = this.data.getLineas().get(0);
        transporte.setLinea(lineaDePrueba);

        for(int i = 0; i < lineaDePrueba.getEstaciones().size(); i++){
            if(i < lineaDePrueba.getEstaciones().size() - 1) {
                lineaDePrueba.getEstaciones().get(i).setSiguiente(lineaDePrueba.getEstaciones().get(i + 1));
            }else{
                lineaDePrueba.getEstaciones().get(i).setSiguiente(null);
            }
        }

        tramoDePrueba.setPuntoA(origen);
        tramoDePrueba.setPuntoB(destino);
        tramoDePrueba.setTransporte(transporte);

        Assert.assertEquals(new Double(1500.93), tramoDePrueba.obtenerDistancia());

    }

    private class ParadasData {
        @Getter @Setter private List<dds.tp.carbono.entities.transport.Linea> lineas;
    }
}
