package dds.tp.carbono.entities.huella;


import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import lombok.Setter;
import lombok.Getter;

public class BuscadorFactorEmision {

    @Getter @Setter FactorEmisionRepository repository;
    public BuscadorFactorEmision(FactorEmisionRepository repository){
        this.repository = repository;
    }

    
    public FactorEmision buscarPorConsumoActividad(TipoDeConsumo tipoDeConsumo, TipoActividad actividad){
        
        return this.repository.get(tipoDeConsumo,actividad);
    }


}
