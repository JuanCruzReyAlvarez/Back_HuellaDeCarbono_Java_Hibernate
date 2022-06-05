package dds.tp.carbono.services.miembro.trayecto;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.member.TrayectoDao;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;

public class CreadorDeTrayecto {
    
    private TrayectoDao trayectoDao;

    public CreadorDeTrayecto() {
        this.trayectoDao = new TrayectoDao();
    }

    public Trayecto crear(Trayecto trayecto) {
        List<Tramo> tramosCompartidos = this.tramosCompartidos(trayecto);

        if (tramosCompartidos.size() > 0)
            this.crearTrayectosPendientes(tramosCompartidos);

        return this.trayectoDao.guardar(trayecto);
    }

    private void crearTrayectosPendientes(List<Tramo> tramosCompartidos) {
        CreadorTrayectoPendiente creadorTrayectoPendiente = new CreadorTrayectoPendiente();
        tramosCompartidos.forEach(tramo -> creadorTrayectoPendiente.crear(tramo));
    }

    private List<Tramo> tramosCompartidos(Trayecto trayecto) {
        return trayecto.getTramos()
                       .stream()
                       .filter(t -> t.getCompartidos().size() > 0)
                       .collect(Collectors.toList());
    }
}
