package dds.tp.carbono.dao.agenteSectorial;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;

public class SectorMunicipalDao extends Dao<SectorMunicipal> {
    
    private static SectorMunicipalDao instance;

    public static SectorMunicipalDao getInstance() {
        if (instance == null)
            instance = new SectorMunicipalDao();

        return instance;
    }

    @Override
    public SectorMunicipal setId(Integer id, SectorMunicipal item) {
        item.setId(id);
        return item;
    }
}
