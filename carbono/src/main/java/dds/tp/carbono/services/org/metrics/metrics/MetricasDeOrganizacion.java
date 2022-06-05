package dds.tp.carbono.services.org.metrics.metrics;

import lombok.Getter;
import lombok.Setter;

public class MetricasDeOrganizacion {
    @Setter @Getter private Actividad actividad;
    @Setter @Getter private TipoDeConsumo tipoDeConsumo;
    @Setter @Getter private Consumo consumo;
    @Setter @Getter private PeriodoDeImputacion periodoDeImputacion;

    public boolean isValid() {
        return this.actividad != null &&
                this.periodoDeImputacion != null &&
                this.tipoDeConsumo != null &&
                this.consumo != null;
    }
}
