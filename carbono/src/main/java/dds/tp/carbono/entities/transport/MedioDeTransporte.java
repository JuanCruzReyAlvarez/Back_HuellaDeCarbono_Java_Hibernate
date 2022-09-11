package dds.tp.carbono.entities.transport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class MedioDeTransporte {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    public abstract Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception;

    public abstract TipoDeConsumo getCombustible() throws Exception;

}
