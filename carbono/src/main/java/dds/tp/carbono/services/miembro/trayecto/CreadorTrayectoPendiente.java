package dds.tp.carbono.services.miembro.trayecto;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.TrayectoPendiente;
import dds.tp.carbono.repository.member.TrayectoPendienteRepository;

public class CreadorTrayectoPendiente {
    
    private TrayectoPendienteRepository repository;

    public CreadorTrayectoPendiente() {
        this.repository = new TrayectoPendienteRepository();
    }

    public TrayectoPendiente crear(Tramo tramo) {
        return this.repository.guardar(new TrayectoPendiente(tramo));
    }
}
