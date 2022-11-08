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
    @Setter @Getter public Double valor;

    @Enumerated(value = EnumType.STRING)
    @Setter @Getter public Periodicidad periodicidad;
    
    @Enumerated(value = EnumType.STRING)
    @Setter @Getter public Unidad unidad;

    @Enumerated(value = EnumType.STRING)
    @Setter @Getter public TipoDeConsumo tipo;

    public Consumo(){}


}
