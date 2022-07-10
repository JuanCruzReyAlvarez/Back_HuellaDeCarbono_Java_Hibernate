package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;

public class CombustionMovil extends Actividad {
    
    @Setter @Getter public Consumo consumo;
    
    public CombustionMovil(Consumo consumo) {
        this.consumo = consumo;
        this.tipoActividad = TipoActividad.Combustion_Movil;
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
