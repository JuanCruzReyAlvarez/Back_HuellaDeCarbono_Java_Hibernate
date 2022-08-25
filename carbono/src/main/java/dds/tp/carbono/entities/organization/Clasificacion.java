package dds.tp.carbono.entities.organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clasificacion")
public class Clasificacion {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;

    public Clasificacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
