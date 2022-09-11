package dds.tp.carbono.entities.organization;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;


import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Clasificacion {

    @Transient
    @Getter @Setter private Integer id;

    @Column (name = "clasificacion")
    @Getter @Setter private String nombre;

    public Clasificacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
