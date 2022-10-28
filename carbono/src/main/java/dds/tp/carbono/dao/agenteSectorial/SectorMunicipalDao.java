package dds.tp.carbono.dao.agenteSectorial;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;

public class SectorMunicipalDao extends Dao<SectorMunicipal> {

    private static SectorMunicipalDao instance;

    public static SectorMunicipalDao getInstance() {
        if (instance == null)
            instance = new SectorMunicipalDao();

        return instance;
    }


}