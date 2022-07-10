package dds.tp.carbono.repository.agenteSectorial;

import dds.tp.carbono.dao.agenteSectorial.SectorMunicipalDao;
import dds.tp.carbono.dao.agenteSectorial.SectorProvincialDao;
import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;

public class SectorTerritorialRepository {
    
    private SectorMunicipalDao sectorMunicipalDao;
    private SectorProvincialDao sectorProvincialDao;

    public SectorTerritorialRepository() {
        this.sectorMunicipalDao = SectorMunicipalDao.getInstance();
        this.sectorProvincialDao = SectorProvincialDao.getInstance();
    }

    public SectorTerritorial guardar(SectorTerritorial sectorTerritorial) {
        
        if (sectorTerritorial instanceof SectorMunicipal)
            return this.sectorMunicipalDao.save((SectorMunicipal)sectorTerritorial);
        else if (sectorTerritorial instanceof SectorProvincial)
            return this.sectorProvincialDao.save((SectorProvincial)sectorTerritorial);

        return null;
    }
}