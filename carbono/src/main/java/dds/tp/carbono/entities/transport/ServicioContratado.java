package dds.tp.carbono.entities.transport;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicioContratado")
public class ServicioContratado implements MedioDeTransporte {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private TipoDeConsumo combustible;

    @Embedded
    @Getter @Setter private TipoServicioContratado tipo;


    @Transient
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }
}

