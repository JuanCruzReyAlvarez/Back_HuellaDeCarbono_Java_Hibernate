package dds.tp.carbono.services.external.dto;

import lombok.Setter;
import lombok.Getter;

public class Localidad implements GeoInfo {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    public Localidad(String localidad) {
        this.nombre = localidad;
    }
}
