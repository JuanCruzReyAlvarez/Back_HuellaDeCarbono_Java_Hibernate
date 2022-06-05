package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class TipoMedioNoMotorizado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return Double.valueOf(0);
    }
}
