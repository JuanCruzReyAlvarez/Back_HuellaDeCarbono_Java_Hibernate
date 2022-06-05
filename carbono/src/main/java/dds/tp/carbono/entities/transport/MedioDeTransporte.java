package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;

public interface MedioDeTransporte {
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception;
}
