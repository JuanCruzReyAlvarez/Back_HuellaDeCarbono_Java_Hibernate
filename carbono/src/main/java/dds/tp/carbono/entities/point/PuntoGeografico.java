package dds.tp.carbono.entities.point;

import lombok.Getter;
import lombok.Setter;

public class PuntoGeografico {
    @Getter @Setter private Integer id;
    @Getter @Setter private String direccion;
    @Getter @Setter private Double latitud;
    @Getter @Setter private Double longitud;
}
