package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.member.Miembro;

public class MiembroDao extends Dao<Miembro> {

    private static MiembroDao instance;

    public static MiembroDao getInstance() {
        if (instance == null)
            instance = new MiembroDao();

        return instance;
    }

    
}
