package dds.tp.carbono.distancia;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;

public class CalcularDistanciaTest {

    @Test
    public void requestDistancias() throws Exception {

        PuntoGeografico origen = new PuntoGeografico();
        origen.setIdLocalidad(1);
        origen.setCalle("cabildo");
        origen.setAltura("5678");
        
        PuntoGeografico destino = new PuntoGeografico();
        destino.setIdLocalidad(1);
        destino.setCalle("cabildo");
        destino.setAltura("1234");
        
        CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
        
        Double distancia = calculador.calcularDistancia(origen, destino);

        Assert.assertNotNull(distancia);
    }
}
