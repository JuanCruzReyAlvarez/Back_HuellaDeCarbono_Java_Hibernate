package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.TransporteParticularDao;
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

}
