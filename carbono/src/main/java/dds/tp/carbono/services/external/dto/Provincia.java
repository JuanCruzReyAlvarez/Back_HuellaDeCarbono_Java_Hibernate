package dds.tp.carbono.services.external.dto;

import lombok.Getter;
import lombok.Setter;

public class Provincia implements GeoInfo {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    public Provincia(String provincia) {
        this.nombre = provincia;
    }
}
