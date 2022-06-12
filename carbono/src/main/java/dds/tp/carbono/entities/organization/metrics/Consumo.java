package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;

public class Consumo {
    @Setter @Getter private Double valor;
    @Setter @Getter private Periodicidad periodicidad;
    @Setter @Getter private Unidad unidad;
    @Setter @Getter private TipoDeConsumo tipo;
}
