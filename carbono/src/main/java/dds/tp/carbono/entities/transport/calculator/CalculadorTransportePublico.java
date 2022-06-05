package dds.tp.carbono.entities.transport.calculator;

import dds.tp.carbono.entities.transport.Estacion;

import java.util.ArrayList;
import java.util.List;

public class CalculadorTransportePublico {

    public Double calcularDistancia(Estacion estacionInicio, Estacion estacionFin) {
        List<Estacion> estacionesDelRecorrido = new ArrayList<>();
        Estacion estacionActual = estacionInicio;

        while (estacionActual.getId() != estacionFin.getId()) {
            estacionActual = estacionActual.getSiguiente();
            estacionesDelRecorrido.add(estacionActual);
        }
        return estacionesDelRecorrido.stream().mapToDouble(estacion -> estacion.getDistanciaEstacionAnterior()).sum();
    }
}
