package dds.tp.carbono.entities.transport;

import javax.persistence.Embedded;
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
@Table(name = "servicio_Contratado")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ServicioContratado extends MedioDeTransporte {

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoDeConsumo combustible;

    @Embedded
    @Getter @Setter private TipoServicioContratado tipo;


    @Transient
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();


    public ServicioContratado(){}
    
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }
}

