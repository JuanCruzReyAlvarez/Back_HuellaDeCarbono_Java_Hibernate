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
@Table(name="municipio")
public class Municipio implements GeoInfo {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    @Column
    @Getter @Setter private String nombre;

    //( cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter private Provincia provincia;
    
    
    public  Municipio() {
          
    }
    
    public  Municipio(String municipio) {
        this.nombre = municipio;  
    }
    public  Municipio(Integer id) {
        this.id = id;  
    }
    public  Municipio(String nombre,Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;  
    }
}
