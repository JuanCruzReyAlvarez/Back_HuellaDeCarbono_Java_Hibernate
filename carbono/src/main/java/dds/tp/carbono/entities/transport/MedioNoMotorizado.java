package dds.tp.carbono.entities.transport;

import lombok.Getter;
import lombok.Setter;

public class MedioNoMotorizado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoMedioNoMotorizado tipo;
}
