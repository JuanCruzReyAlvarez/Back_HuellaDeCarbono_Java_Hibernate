package dds.tp.carbono.repository.member;

import dds.tp.carbono.dao.member.TrayectoPendienteDao;
import dds.tp.carbono.entities.member.TrayectoPendiente;

public class TrayectoPendienteRepository {
    
    private TrayectoPendienteDao dao;
 
    public TrayectoPendienteRepository() {
        this.dao = TrayectoPendienteDao.getInstance();
        this.dao.setClazz(TrayectoPendiente.class);
    }

    public TrayectoPendiente guardar(TrayectoPendiente trayectoPendiente) {
        return this.dao.save(trayectoPendiente);
    }
}
