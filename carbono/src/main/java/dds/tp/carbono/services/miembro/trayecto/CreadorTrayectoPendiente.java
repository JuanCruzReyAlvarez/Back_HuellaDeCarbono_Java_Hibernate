package dds.tp.carbono.services.miembro.trayecto;

import dds.tp.carbono.dao.member.TrayectoPendienteDao;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.TrayectoPendiente;

public class CreadorTrayectoPendiente {
    
    private TrayectoPendienteDao trayectoPendienteDao;

    public CreadorTrayectoPendiente() {
        this.trayectoPendienteDao = new TrayectoPendienteDao();
    }

    public TrayectoPendiente crear(Tramo tramo) {
        return this.trayectoPendienteDao.guardar(new TrayectoPendiente(tramo));
    }
}
