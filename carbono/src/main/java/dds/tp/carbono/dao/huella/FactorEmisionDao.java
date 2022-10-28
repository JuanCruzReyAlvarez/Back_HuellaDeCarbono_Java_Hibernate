package dds.tp.carbono.dao.huella;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.huella.FactorEmision;

public class FactorEmisionDao extends Dao<FactorEmision> {

    private static FactorEmisionDao instance;

    public static FactorEmisionDao getInstance() {
        if (instance == null)
            instance = new FactorEmisionDao();

        return instance;
    }


}
