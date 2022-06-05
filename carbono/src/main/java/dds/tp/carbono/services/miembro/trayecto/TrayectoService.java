package dds.tp.carbono.services.miembro.trayecto;

import dds.tp.carbono.dao.member.TrayectoDao;
import dds.tp.carbono.entities.member.Trayecto;

public class TrayectoService {
    
    private TrayectoDao trayectoDao;

    public TrayectoService() {
        this.trayectoDao = new TrayectoDao();
    }

    public Trayecto crear(Trayecto trayecto) {

        trayecto = this.trayectoDao.guardar(trayecto);

        return trayecto;
    }

}
