package dds.tp.carbono.entities.transport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "estacion")
public class Estacion {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;

    @OneToOne
    @Getter @Setter private PuntoGeografico ubicacion;

    @Column
    @Getter @Setter private Integer distanciaEstacionAnterior;
    
    @OneToOne
    @Getter @Setter private Estacion siguiente;

    public Estacion(){}
}
