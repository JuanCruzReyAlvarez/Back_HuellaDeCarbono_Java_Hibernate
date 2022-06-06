package dds.tp.carbono.repository.member;

import dds.tp.carbono.dao.member.TrayectoDao;
import dds.tp.carbono.entities.member.Trayecto;

public class TrayectoRepository {

    private TrayectoDao dao;

    public TrayectoRepository() {
        this.dao = TrayectoDao.getInstance();
    }
    
    public Trayecto guardar(Trayecto trayecto) {
        return this.dao.save(trayecto);
    }
}
