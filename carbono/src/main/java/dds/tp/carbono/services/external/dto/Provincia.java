package dds.tp.carbono.services.external.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="provincia")
public class Provincia implements GeoInfo {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter private Pais pais;
    
    public Provincia() {
    }
    /* public Provincia(String provincia ) {
        this.nombre = provincia;  
    }
    public Provincia( Integer id ) {
        this.id = id;  
    }*/
    
}
