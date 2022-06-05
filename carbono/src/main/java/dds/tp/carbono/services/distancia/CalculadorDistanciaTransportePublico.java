package dds.tp.carbono.services.distancia;

import dds.tp.carbono.entities.transport.Estacion;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDistanciaTransportePublico {

    public Double calcularDistancia(Estacion estacionInicio, Estacion estacionFin) {
        List<Estacion> estacionesDelRecorrido = new ArrayList<>();
        Estacion estacionActual = estacionInicio;

        while (!estacionActual.getId().equals(estacionFin.getId())) {
            estacionActual = estacionActual.getSiguiente();
            estacionesDelRecorrido.add(estacionActual);
        }

        return estacionesDelRecorrido.stream().mapToDouble(estacion -> estacion.getDistanciaEstacionAnterior()).sum();
    }
}
