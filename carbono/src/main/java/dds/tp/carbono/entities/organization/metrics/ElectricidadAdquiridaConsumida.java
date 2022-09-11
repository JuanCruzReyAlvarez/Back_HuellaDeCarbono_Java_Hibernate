package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("electricidadAdquiridaConsumida")
public class ElectricidadAdquiridaConsumida extends Actividad {
    
    @Embedded
    @Setter @Getter public Consumo consumo;
    
    public ElectricidadAdquiridaConsumida(Consumo consumo) {
        this.consumo = consumo;
        this.tipoActividad = TipoActividad.Electricidad_Adquirida_Consumida;
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
