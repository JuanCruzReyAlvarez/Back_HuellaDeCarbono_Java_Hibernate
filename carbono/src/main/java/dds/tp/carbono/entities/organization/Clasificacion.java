package dds.tp.carbono.entities.organization;

import lombok.Getter;
import lombok.Setter;

public class Clasificacion {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;

    public Clasificacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
