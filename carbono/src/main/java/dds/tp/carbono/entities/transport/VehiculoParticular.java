package dds.tp.carbono.entities.transport;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Transient;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;


@Entity

@PrimaryKeyJoinColumn(name="medio_transporte_id")
public class VehiculoParticular extends MedioDeTransporte {
    @Transient
    @Getter @Setter private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoVehiculoParticular tipo;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoDeConsumo combustible;


    public VehiculoParticular(){}

    public VehiculoParticular(TipoVehiculoParticular tipo, TipoDeConsumo combustible){
        this.setTipo(tipo);
        this.setCombustible(combustible);
    }

    @Transient
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }
}
