package dds.tp.carbono.entities.organization.metrics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;


@Embeddable
public class Consumo {

    @Column
    @Setter @Getter private Double valor;

    @Enumerated(EnumType.STRING)
    @Setter @Getter private Periodicidad periodicidad;
    
    @Enumerated(EnumType.STRING)
    @Setter @Getter private Unidad unidad;

    @Enumerated(EnumType.STRING)
    @Setter @Getter private TipoDeConsumo tipo;
}
