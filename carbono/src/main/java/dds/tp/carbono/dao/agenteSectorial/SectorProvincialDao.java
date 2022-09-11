package dds.tp.carbono.dao.agenteSectorial;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;

public class SectorProvincialDao extends Dao<SectorProvincial> {
    
    private static SectorProvincialDao instance;

    public static SectorProvincialDao getInstance() {
        if (instance == null)
            instance = new SectorProvincialDao();

        return instance;
    }

    @Override
    public SectorProvincial setId(Integer id, SectorProvincial item) {
        item.setId(id);
        return item;
    }
}
