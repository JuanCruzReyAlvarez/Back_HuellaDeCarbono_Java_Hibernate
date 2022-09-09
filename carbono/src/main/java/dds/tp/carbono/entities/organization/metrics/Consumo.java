package dds.tp.carbono.entities.organization.metrics;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Embeddable
public class Consumo {


    @Setter @Getter private Double valor;
    @Setter @Getter private Periodicidad periodicidad;
    @Setter @Getter private Unidad unidad;
    @Setter @Getter private TipoDeConsumo tipo;
}
