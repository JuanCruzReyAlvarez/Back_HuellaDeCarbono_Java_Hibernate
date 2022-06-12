package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaTransportePublico;
import lombok.Getter;
import lombok.Setter;

public class TransportePublico implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoTransportePublico tipo;
    @Getter @Setter private TipoDeConsumo combustible;
    @Getter @Setter private Linea linea;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        Estacion estacionInicio = this.linea.getEstacionByUbicacion(inicio);
        Estacion estacionFin = this.linea.getEstacionByUbicacion(fin);

        CalculadorDistanciaTransportePublico calculador = new CalculadorDistanciaTransportePublico();
        return calculador.calcularDistancia(estacionInicio, estacionFin);
    }
}
