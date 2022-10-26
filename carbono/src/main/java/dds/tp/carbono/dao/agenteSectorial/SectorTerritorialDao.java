package dds.tp.carbono.dao.agenteSectorial;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;

public class SectorTerritorialDao extends Dao<SectorTerritorial> {
    
    private static SectorTerritorialDao instance;

    public static SectorTerritorialDao getInstance() {
        if (instance == null)
            instance = new SectorTerritorialDao();

        return instance;
    }


}