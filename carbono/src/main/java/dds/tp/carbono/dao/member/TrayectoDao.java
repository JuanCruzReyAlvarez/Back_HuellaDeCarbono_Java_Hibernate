package dds.tp.carbono.dao.member;

import java.util.List;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.TrayectoRepository;

public class TrayectoDao {

    private TrayectoRepository repository;

    public TrayectoDao() {
        this.repository = TrayectoRepository.getInstance();
    }

    public List<Trayecto> obtenerTodos() {
        return this.repository.getAll();
    }

    public Trayecto guardar(Trayecto trayecto) {
        List<Tramo> tramosCompartidos = this.tramosCompartidos(trayecto);

        if (tramosCompartidos.size() > 0) {

        }

        this.repository.save(trayecto);
    }

    private List<Tramo> tramosCompartidos(Trayecto trayecto) {
        return null;
    }
}
