package dds.tp.carbono.distancia;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.entities.transport.Estacion;
import lombok.Getter;
import lombok.Setter;

public class DistanciaEntreParadas {

    private ParadasData data = null;
    
    @Before
    public void init() {
        String fileName = "paradas.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.data = new Gson().fromJson(new InputStreamReader(is), ParadasData.class);
        } catch (Exception ex) { }
    }

    @Test
    public void distancia() {

        this.data.getLineas().stream().forEach((Linea linea) -> { 
            System.out.println("Linea: " + linea.getNombre()); 
            System.out.println("Estaciones"); 
            linea.getEstaciones().stream().forEach((Estacion estacion) -> {
                System.out.println(String.format("%d: %s - Distancia Anterior: %f", estacion.getId(), estacion.getUbicacion().getDireccion(), estacion.getDistanciaAnterior())); 
            });
        });
         
       
    }

    private class ParadasData {
        @Getter @Setter private List<dds.tp.carbono.entities.transport.Linea> lineas;
    }
}
