package dds.tp.carbono.services.miembro.trayecto;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.member.TrayectoRepository;

// Es un service no pertenece a dominio no hay drama con el repository

public class CreadorDeTrayecto {
    
    private TrayectoRepository repository;

    public CreadorDeTrayecto() {
        this.repository = new TrayectoRepository();
    }

    public Trayecto crear(Trayecto trayecto) throws Exception {

        if (!trayecto.isValid())
            throw new Exception("Trayecto Invalido");

        List<Tramo> tramosCompartidos = this.tramosCompartidos(trayecto);

        if (tramosCompartidos.size() > 0)
            this.crearTrayectosPendientes(tramosCompartidos);

        return this.repository.guardar(trayecto);
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
