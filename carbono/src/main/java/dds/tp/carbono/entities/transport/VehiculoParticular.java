package dds.tp.carbono.entities.transport;

import lombok.Getter;
import lombok.Setter;

public class VehiculoParticular implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoVehiculoParticular tipo;
    @Getter @Setter private TipoCombustible combustible;
}
