package dds.tp.carbono.dao.agenteSectorial;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;

public class SectorProvincialDao extends Dao<SectorProvincial> {

    private static SectorProvincialDao instance;

    public static SectorProvincialDao getInstance() {
        if (instance == null)
            instance = new SectorProvincialDao();

        return instance;
    }

    public SectorProvincial getById(Integer idSectorProvincial) {
        return findOne(idSectorProvincial);
    }


}
	