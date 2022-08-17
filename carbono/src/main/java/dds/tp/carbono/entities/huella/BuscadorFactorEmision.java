package dds.tp.carbono.entities.huella;

import java.util.List;

import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import lombok.Setter;

public class BuscadorFactorEmision {
    @Setter List<FactorEmision> factoresDeEmision;

    public BuscadorFactorEmision(List<FactorEmision> factoresDeEmision){
        this.factoresDeEmision = factoresDeEmision;
    }
    
    public FactorEmision buscarPorConsumoActividad(TipoDeConsumo tipoDeConsumo, TipoActividad actividad){
        
            return this.factoresDeEmision
                        .stream()
                        .filter(fe -> fe.getTipoDeConsumo().equals(tipoDeConsumo) 
                                  && fe.getTipoActividad().equals(actividad))
                        .findFirst()
                        .orElse(null);
    }

}
