package dds.tp.carbono.services.external.dto;

import lombok.Setter;

import javax.persistence.CascadeType;
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
    @ManyToOne( cascade = {CascadeType.ALL}, fetch = FetchType.EAGER )
    @Getter @Setter private Provincia provincia;
    
    
    public  Municipio() {
          
    }
    
    public  Municipio(String municipio) {
        this.nombre = municipio;  
    }
    public  Municipio(Integer id) {
        this.id = id;  
    }
}
