package dds.tp.carbono.repository.huella;

import dds.tp.carbono.dao.huella.FactorEmisionDao;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;

public class FactorEmisionRepository {
    
    private FactorEmisionDao dao;

    public FactorEmisionRepository() {
        this.dao = FactorEmisionDao.getInstance();
    }

    public FactorEmision get(TipoDeConsumo tipoDeConsumo) {
        return this.dao.getAll()
                       .stream()
                       .filter(fe -> fe.getTipoDeConsumo().equals(tipoDeConsumo))
                       .findFirst()
                       .orElse(null);
    }

    public FactorEmision guardarOActualizar(FactorEmision fe) {
        FactorEmision factorEmision = this.get(fe.getTipoDeConsumo());

        if (factorEmision == null)
            return this.dao.save(fe);
        else 
            return this.actualizarValor(fe);
    }

    private FactorEmision actualizarValor(FactorEmision updated) {
        for (FactorEmision fe : this.dao.getAll())
            if (fe.getId().equals(updated.getId())) {
                fe.setValor(updated.getValor());
                return fe;
            }
        
        return null;
    }
}
