package dds.tp.carbono.dao.member;

import dds.tp.carbono.entities.member.TrayectoPendiente;
import dds.tp.carbono.repository.TrayectoPendienteRepository;

public class TrayectoPendienteDao {
    
    private TrayectoPendienteRepository repository;
 
    public TrayectoPendienteDao() {
        this.repository = TrayectoPendienteRepository.getInstance();
    }

    public TrayectoPendiente guardar(TrayectoPendiente trayectoPendiente) {
        return this.repository.save(trayectoPendiente);
    }
}
