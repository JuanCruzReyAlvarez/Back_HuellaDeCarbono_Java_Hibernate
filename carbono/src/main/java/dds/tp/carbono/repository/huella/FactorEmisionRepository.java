package dds.tp.carbono.repository.huella;

import java.util.List;

import dds.tp.carbono.dao.huella.FactorEmisionDao;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;

public class FactorEmisionRepository {
    
    private FactorEmisionDao dao;

    public FactorEmisionRepository() {
        this.dao = FactorEmisionDao.getInstance();
        this.dao.setClazz(FactorEmision.class);
    }

    public FactorEmision get(TipoDeConsumo tipoDeConsumo, TipoActividad actividad) {
        return this.dao.getAll()
                       .stream()
                       .filter(fe -> fe.getTipoDeConsumo().equals(tipoDeConsumo) 
                                  && fe.getTipoActividad().equals(actividad))
                       .findFirst()
                       .orElse(null);
    }

    public FactorEmision getById(Integer id) {
        return this.dao.getAll()
                       .stream()
                       .filter(fe -> fe.getId().equals(id) )
                       .findFirst()
                       .orElse(null);
    }

    public FactorEmision guardarOActualizar(FactorEmision fe) {
        FactorEmision factorEmision = this.getById(fe.getId());

        if (factorEmision == null)
            return this.dao.save(fe);
        else 
             this.dao.deleteById(fe.getId());
             return this.dao.save(fe);
    }


    public List<FactorEmision> getAll() {
        return this.dao.getAll();
    }

   
}
