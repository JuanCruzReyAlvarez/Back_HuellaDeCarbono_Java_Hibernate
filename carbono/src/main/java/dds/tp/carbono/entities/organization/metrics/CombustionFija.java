package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;

public class CombustionFija extends Actividad {

    @Setter @Getter public Consumo consumo;

    public CombustionFija(Consumo consumo) {
        this.consumo = consumo;
        this.tipoActividad = TipoActividad.Combustion_Fija;
    }

    @Override
    protected Double getValorDA() {
        return this.consumo.getValor();
    }

    @Override
    protected Unidad getUnidadDA() {
        return this.consumo.getUnidad();
    }

    @Override
    public TipoDeConsumo getTipoDeConsumo() {
        return this.consumo.getTipo();
    }
}
