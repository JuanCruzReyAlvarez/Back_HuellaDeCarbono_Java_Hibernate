package dds.tp.carbono.entities.transport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Medio_de_transporte")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class MedioDeTransporte {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    public abstract Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception;

    public abstract TipoDeConsumo getCombustible() throws Exception;

}
