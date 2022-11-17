package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.TransporteParticularDao;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.transport.TipoVehiculoParticular;
import dds.tp.carbono.entities.transport.VehiculoParticular;

public class TransporteParticularRepository {
    private TransporteParticularDao dao;

    public TransporteParticularRepository() {
        this.dao = TransporteParticularDao.getInstance();
        this.dao.setClazz(VehiculoParticular.class);
        
    }
    
    public void guardar(VehiculoParticular transporte) {
        this.dao.save(transporte);
    }
    public VehiculoParticular getByTipoYCombustible(TipoDeConsumo consumo, TipoVehiculoParticular vehiculo ) {
        return this.dao.getAll()
                       .stream()
                       .filter(o -> o.getCombustible().equals(consumo)
                                                && o.getTipo().equals(vehiculo))
                                                .findFirst()
                                                .orElse(null);
    }

}
