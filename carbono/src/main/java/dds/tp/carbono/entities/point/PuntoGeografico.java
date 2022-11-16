package dds.tp.carbono.entities.point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.services.external.dto.Localidad;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "punto_Geografico")
public class PuntoGeografico {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Transient
    @Getter @Setter private String direccion; // ?

    @Transient
    @Getter @Setter private Double latitud;

    @Transient
    @Getter @Setter private Double longitud;

    @Column
    @Getter @Setter private String calle;
    
    @Column
    @Getter @Setter private String altura;

    @ManyToOne( fetch = FetchType.EAGER)
    @Getter @Setter private Localidad localdiad;

    public PuntoGeografico(){}

    public PuntoGeografico(Integer idLocalidad){
            this.localdiad.setId(idLocalidad); 
    }
    public PuntoGeografico(String altura, String calle, Integer localidad_id){
        this.setAltura(altura);
        this.setCalle(calle);
        this.setLocaldiad(new Localidad(localidad_id)); 
}

    
}
