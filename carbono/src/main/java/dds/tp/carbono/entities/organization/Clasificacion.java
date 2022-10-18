package dds.tp.carbono.entities.organization;

import javax.persistence.Column;
import javax.persistence.Embeddable;



import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Clasificacion {

    @Column (name = "clasificacion")
    @Getter @Setter private String nombre;


    public Clasificacion() {
      
    }
    
    public Clasificacion(String nombre) {
        this.nombre = nombre;
    }
}
