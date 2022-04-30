package dds.tp.carbono.entities.point;

import lombok.Getter;
import lombok.Setter;

public class PuntoArbitrario implements Ubicable {
    @Getter @Setter private String detalle;
    @Getter @Setter private PuntoGeografico ubicacion;
}
