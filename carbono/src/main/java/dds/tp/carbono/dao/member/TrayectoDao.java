package dds.tp.carbono.dao.member;

import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.TrayectoRepository;

public class TrayectoDao {

    private TrayectoRepository repository;

    public TrayectoDao() {
        this.repository = TrayectoRepository.getInstance();
    }
    
    public Trayecto guardar(Trayecto trayecto) {
        return this.repository.save(trayecto);
    }
}
