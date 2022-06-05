package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class TransportePublico implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoTransportePublico tipo;
    @Getter @Setter private Linea linea;

    public TransportePublico() {
        PuntoGeografico ubicacion = new PuntoGeografico();
        linea.getEstaciones().stream().map(e -> e.getDistanciaAnterior()).reduce(Double::sum);
        linea.getEstaciones().stream().filter(estacion -> estacion.getUbicacion().getId().equals(ubicacion.getId())).findFirst().orElseThrow();
    }
}
