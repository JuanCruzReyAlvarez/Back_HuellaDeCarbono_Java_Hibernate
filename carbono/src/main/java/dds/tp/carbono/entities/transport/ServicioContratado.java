package dds.tp.carbono.entities.transport;

import lombok.Getter;
import lombok.Setter;

public class ServicioContratado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoServicioContratado tipo;
}
