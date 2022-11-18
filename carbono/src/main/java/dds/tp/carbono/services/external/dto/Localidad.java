package dds.tp.carbono.services.external.dto;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name="localidad")
public class Localidad implements GeoInfo {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    @Column
    @Getter @Setter private String nombre;

    //@ManyToOne( cascade = {CascadeType.ALL}, fetch = FetchType.EAGER )
    @ManyToOne(fetch = FetchType.EAGER )
    @Getter @Setter private Municipio municipio;
    
    
    

    public Localidad() {
    }

    public Localidad(String localidad) {
        this.nombre = localidad;   
    }
    public Localidad(Integer id) {
        this.setId(id);
    }
}
