package dds.tp.carbono.entities.huella;

import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;
import lombok.Getter;
import lombok.Setter;

public class FactorEmision {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoDeConsumo tipoDeConsumo;
    @Getter @Setter private Double valor;
    @Getter @Setter private Unidad unidad;
}
