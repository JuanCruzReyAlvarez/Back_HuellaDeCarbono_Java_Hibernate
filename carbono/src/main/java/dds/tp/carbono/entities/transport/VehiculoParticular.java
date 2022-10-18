package dds.tp.carbono.entities.transport;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "vehiculo_particular")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VehiculoParticular extends MedioDeTransporte {
    @Transient
    @Getter @Setter private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoVehiculoParticular tipo;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoDeConsumo combustible;


    public VehiculoParticular(){}

    @Transient
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }
}
