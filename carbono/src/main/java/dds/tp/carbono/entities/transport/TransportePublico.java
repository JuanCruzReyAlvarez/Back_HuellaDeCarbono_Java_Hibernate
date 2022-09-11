package dds.tp.carbono.entities.transport;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.glassfish.hk2.api.InheritableThread;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaTransportePublico;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToOne;

@Entity
@Table(name = "transporte_Publico")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TransportePublico extends MedioDeTransporte {

    @Transient
    @Getter @Setter private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoTransportePublico tipo;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoDeConsumo combustible;

    @OneToOne
    @Getter @Setter private Linea linea;

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        Estacion estacionInicio = this.linea.getEstacionByUbicacion(inicio);
        Estacion estacionFin = this.linea.getEstacionByUbicacion(fin);

        CalculadorDistanciaTransportePublico calculador = new CalculadorDistanciaTransportePublico();
        return calculador.calcularDistancia(estacionInicio, estacionFin);
    }
}
