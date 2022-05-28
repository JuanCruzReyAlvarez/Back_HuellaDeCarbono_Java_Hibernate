package dds.tp.carbono.services.external.dto;

import lombok.Getter;
import lombok.Setter;

public class Pais implements GeoInfo {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    public Pais(String pais) {
        this.nombre = pais;
    }
}
