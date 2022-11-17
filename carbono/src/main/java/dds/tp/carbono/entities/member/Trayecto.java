package dds.tp.carbono.entities.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.validators.trayecto.TrayectoValidator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "trayecto")
public class Trayecto {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Getter @Setter public PuntoGeografico puntoPartida;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Getter @Setter public PuntoGeografico puntoLlegada;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Getter @Setter public List<Tramo> tramos;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "miembro_id", referencedColumnName = "id" )
    @Getter @Setter public Miembro miembro;

    @Column(name = "fecha", columnDefinition = "DATE")
    @Setter @Getter public LocalDate fecha;                


    @Transient
    private Double distancia = null;

    public Trayecto(){}

    public Trayecto(int a) {
        this.tramos = new ArrayList<Tramo>();
    }

     public Trayecto(PuntoGeografico org ,PuntoGeografico dest, List<Tramo> tramos,Miembro miembro ) {
        this.tramos = tramos;
        this.puntoPartida = org;
        this.puntoLlegada= dest;
       this.miembro= miembro;
    }

    public Boolean isValid() {
        return new TrayectoValidator().validate(this);
    }

    public Double obtenerDistancia() {
        
        if (this.distancia != null)
            return this.distancia;

        this.distancia = Double.valueOf(0);

        for (Tramo tramo : this.getTramos())
            this.distancia += tramo.obtenerDistancia();
        
        return this.distancia;
    }

    public Tramo getTramoCompartido() {
        return this.tramos.stream().filter(t -> t.getCompartidos().size() > 0).findFirst().orElse(null);
    }
}
