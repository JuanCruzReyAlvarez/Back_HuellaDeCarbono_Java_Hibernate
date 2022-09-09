package dds.tp.carbono.entities.transport;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class TipoServicioContratado {
    
    @Transient
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;

    public TipoServicioContratado(String nombre) {
        this.nombre = nombre;
    }
}
