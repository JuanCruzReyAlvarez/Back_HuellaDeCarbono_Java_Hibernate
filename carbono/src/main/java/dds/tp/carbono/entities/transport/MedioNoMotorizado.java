package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class MedioNoMotorizado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoMedioNoMotorizado tipo;

    public MedioNoMotorizado(Integer id, TipoMedioNoMotorizado tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) {
        return Double.valueOf(0);
    }
}

