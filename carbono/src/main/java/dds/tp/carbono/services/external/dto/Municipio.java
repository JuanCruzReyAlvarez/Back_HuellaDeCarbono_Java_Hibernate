package dds.tp.carbono.services.external.dto;

import lombok.Setter;
import lombok.Getter;

public class Municipio implements GeoInfo {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private Provincia provincia;
    
    public Municipio(String municipio) {
        this.nombre = municipio;
    }
}
