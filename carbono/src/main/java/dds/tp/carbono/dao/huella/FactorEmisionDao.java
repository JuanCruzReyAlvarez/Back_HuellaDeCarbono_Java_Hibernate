package dds.tp.carbono.dao.huella;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.huella.FactorEmision;

public class FactorEmisionDao extends Dao<FactorEmision> {

    private static FactorEmisionDao instance;

    public static FactorEmisionDao getInstance() {
        if (instance == null)
            instance = new FactorEmisionDao();

        return instance;
    }

    @Override
    public FactorEmision setId(Integer id, FactorEmision item) {
        item.setId(id);
        return item;
    }
}
