package dds.tp.carbono.repository.organization;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.metrics.CombustionFija;

public class CombustionFijaDao extends Dao<CombustionFija>{
    private static CombustionFijaDao instance;

    public static CombustionFijaDao getInstance() {
        if (instance == null)
            instance = new CombustionFijaDao();

        return instance;
    }

    public CombustionFija getActividadOrganizacion(Integer idActOrg){
        return findOne(idActOrg);
    }
}
