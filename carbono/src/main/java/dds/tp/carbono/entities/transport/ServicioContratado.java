package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class ServicioContratado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoServicioContratado tipo;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) {
        return 0.2; //para que no tire error
    }
}

