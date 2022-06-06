package dds.tp.carbono.entities.member;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
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
    
    public Double obtenerDistancia() throws Exception {
        return this.transporte.calcularDistancia(puntoA, puntoB);
    }

    public Boolean isValid() {
        if (puntoA == null || puntoB == null || transporte == null)
            return false;
            
        return true;
    }
}
