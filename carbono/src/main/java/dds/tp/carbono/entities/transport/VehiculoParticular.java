package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class VehiculoParticular implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoVehiculoParticular tipo;
    @Getter @Setter private TipoCombustible combustible;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) {
        return 0.2; //para que no tire error
    }
}
