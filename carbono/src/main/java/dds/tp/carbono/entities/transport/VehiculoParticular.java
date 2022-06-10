package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import dds.tp.carbono.services.org.metrics.metrics.TipoDeConsumo;
import lombok.Getter;
import lombok.Setter;

public class VehiculoParticular implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoVehiculoParticular tipo;
    @Getter @Setter private TipoDeConsumo combustible;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
        return calculador.calcularDistancia(inicio, fin);
    }
}
