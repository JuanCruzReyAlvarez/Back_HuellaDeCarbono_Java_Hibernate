package dds.tp.carbono.entities.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.validators.tramo.TramoValidator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "tramo")
public class Tramo {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @OneToOne
    @Getter @Setter private PuntoGeografico puntoA;
    @OneToOne
    @Getter @Setter private PuntoGeografico puntoB;

    @Transient
    @Getter @Setter private MedioDeTransporte transporte;

    @OneToMany
    @JoinColumn(name = "tramo_id", referencedColumnName = "id")
    @Getter @Setter private List<Miembro> compartidos;

    public Tramo() {
        this.compartidos = new ArrayList<Miembro>();
    }
    
    public Double obtenerDistancia() {
        try {
            return this.transporte.calcularDistancia(puntoA, puntoB);
        } catch (Exception ex) {
            return Double.valueOf(0);
        }
    }

    public Boolean isValid() {
        return new TramoValidator().validate(this);
    }

    public Boolean esCalculable(){
        return !(this.transporte instanceof MedioNoMotorizado);
    }

}
