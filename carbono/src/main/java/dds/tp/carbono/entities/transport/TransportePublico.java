package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.transport.calculator.CalculadorTransportePublico;
import lombok.Getter;
import lombok.Setter;

public class TransportePublico implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoTransportePublico tipo;
    @Getter @Setter private Linea linea;
    @Getter @Setter CalculadorTransportePublico calculador;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception{
        Estacion estacionInicio = this.linea.getEstacionByUbicacionId(inicio.getId());
        Estacion estacionFin = this.linea.getEstacionByUbicacionId(fin.getId());

        return this.calculador.calcularDistancia(estacionInicio, estacionFin);
    }
}
