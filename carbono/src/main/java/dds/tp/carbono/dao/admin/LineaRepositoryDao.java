package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.transport.Linea;

public class LineaRepositoryDao extends Dao<Linea>{

    private static LineaRepositoryDao instance;

    public static LineaRepositoryDao getInstance() {
        if (instance == null)
            instance = new LineaRepositoryDao();
        return instance;
    }

}
