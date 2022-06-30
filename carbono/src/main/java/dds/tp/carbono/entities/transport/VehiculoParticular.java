package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;

public class VehiculoParticular implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoVehiculoParticular tipo;
    @Getter @Setter private TipoDeConsumo combustible;
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }
}
