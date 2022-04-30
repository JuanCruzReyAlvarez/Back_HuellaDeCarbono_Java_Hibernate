package dds.tp.carbono.entities.transport;

import lombok.Getter;
import lombok.Setter;

public class TransportePublico implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoTransportePublico tipo;
    @Getter @Setter private Linea linea;
}
