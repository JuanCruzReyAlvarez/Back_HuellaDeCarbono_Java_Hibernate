package dds.tp.carbono.repository;

import dds.tp.carbono.entities.member.TrayectoPendiente;

public class TrayectoPendienteRepository extends Repository<TrayectoPendiente>{

    private static TrayectoPendienteRepository instance;

    public static TrayectoPendienteRepository getInstance() {
        if (instance == null)
            instance = new TrayectoPendienteRepository();

        return instance;
    }

    @Override
    public TrayectoPendiente setId(Integer id, TrayectoPendiente item) {
        item.setId(id);
        return item;
    }
}
