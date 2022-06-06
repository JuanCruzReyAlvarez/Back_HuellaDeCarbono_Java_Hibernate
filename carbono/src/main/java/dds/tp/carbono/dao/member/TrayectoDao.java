package dds.tp.carbono.dao.member;

import dds.tp.carbono.entities.member.Trayecto;

public class TrayectoDao extends Dao<Trayecto> {
    
    private static TrayectoDao instance;

    public static TrayectoDao getInstance() {
        if (instance == null)
            instance = new TrayectoDao();

        return instance;
    }

    @Override
    public Trayecto setId(Integer id, Trayecto item) {
        item.setId(id);
        return item;
    }
}
