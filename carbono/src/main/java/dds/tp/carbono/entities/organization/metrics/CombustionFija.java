package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name="actividadId")
public class CombustionFija extends Actividad {

    

    @Embedded
    @Setter @Getter public Consumo consumo;
    
    public CombustionFija() {  }

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
