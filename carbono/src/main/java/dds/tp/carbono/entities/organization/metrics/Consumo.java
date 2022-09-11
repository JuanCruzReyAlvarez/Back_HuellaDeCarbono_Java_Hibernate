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

    @Enumerated(value = EnumType.STRING)
    @Setter @Getter private Periodicidad periodicidad;
    
    @Enumerated(value = EnumType.STRING)
    @Setter @Getter private Unidad unidad;

    @Enumerated(value = EnumType.STRING)
    @Setter @Getter private TipoDeConsumo tipo;
}
