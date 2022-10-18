package dds.tp.carbono.entities.point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dds.tp.carbono.services.external.dto.Localidad;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "punto_Geografico")
public class PuntoGeografico {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private Integer idLocalidad;

    @Column
    @Getter @Setter private String direccion; // ?

    @Column
    @Getter @Setter private Double latitud;

    @Column
    @Getter @Setter private Double longitud;

    @Column
    @Getter @Setter private String calle;
    
    @Column
    @Getter @Setter private String altura;

    @ManyToOne
    @Getter @Setter private Localidad localdiad;

    public PuntoGeografico(){}

    public PuntoGeografico(Integer idLocalidad){
            this.idLocalidad=idLocalidad;
    }

    
}
