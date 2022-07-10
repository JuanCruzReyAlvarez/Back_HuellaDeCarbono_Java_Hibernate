package dds.tp.carbono.entities.member;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;
import dds.tp.carbono.validators.tramo.TramoValidator;
import lombok.Getter;
import lombok.Setter;

public class Tramo {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoGeografico puntoA;
    @Getter @Setter private PuntoGeografico puntoB;
    @Getter @Setter private MedioDeTransporte transporte;
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
