package dds.tp.carbono.repository.organization;

import dds.tp.carbono.entities.organization.metrics.CombustionFija;

public class CombustionFijaRepository {
    private CombustionFijaDao dao; 

    public CombustionFijaRepository() {
        this.dao = CombustionFijaDao.getInstance();
        this.dao.setClazz(CombustionFija.class);
    }

    
    public CombustionFija getActividadOrganizacion(Integer idActOrg) {
        return this.dao.getActividadOrganizacion(idActOrg);
    }
}
