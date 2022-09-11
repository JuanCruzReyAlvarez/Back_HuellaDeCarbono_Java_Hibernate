package dds.tp.carbono.services.miembro.trayecto;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.TrayectoPendiente;
import dds.tp.carbono.repository.member.TrayectoPendienteRepository;

// Es un service no pertenece a dominio no hay drama con el repository

public class CreadorTrayectoPendiente {
    
    private TrayectoPendienteRepository repository;

    public CreadorTrayectoPendiente() {
        this.repository = new TrayectoPendienteRepository();
    }

    public TrayectoPendiente crear(Tramo tramo) {
        return this.repository.guardar(new TrayectoPendiente(tramo));
    }
}
