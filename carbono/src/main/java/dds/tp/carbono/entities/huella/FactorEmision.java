package dds.tp.carbono.entities.huella;

import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import lombok.Getter;
import lombok.Setter;

public class FactorEmision {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoDeConsumo tipoDeConsumo;
    @Getter @Setter private TipoActividad tipoActividad;
    @Getter @Setter private Double valor;
    @Getter @Setter private UnidadFE unidad;

    public FactorEmision() {
        this.valor = 0.0;    
    }

    public FactorEmision(TipoDeConsumo tipoDeConsumo, TipoActividad tipoActividad, Double valor, UnidadFE unidad) {
        this.tipoDeConsumo = tipoDeConsumo;
        this.tipoActividad = tipoActividad;
        this.valor = valor;
        this.unidad = unidad;
    }
}
