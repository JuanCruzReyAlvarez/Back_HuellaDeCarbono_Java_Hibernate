package dds.tp.carbono.repository;

import dds.tp.carbono.entities.member.TrayectoPendiente;

public class TrayectoPendienteRepository extends Repository<TrayectoPendiente>{

    @Override
    public TrayectoPendiente setId(Integer id, TrayectoPendiente item) {
        item.setId(id);
        return item;
    }
    
}
