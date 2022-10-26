package dds.tp.carbono.repository.agenteSectorial;


import dds.tp.carbono.dao.agenteSectorial.SectorTerritorialDao;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;

public class SectorTerritorialRepository {
    
    private SectorTerritorialDao dao;
    

    public SectorTerritorialRepository() {
        this.dao = SectorTerritorialDao.getInstance();
        this.dao.setClazz(SectorTerritorial.class);    
    }


    public SectorTerritorial guardar(SectorTerritorial sectorTerritorial) {
 
        return this.dao.save(sectorTerritorial);
    }

    public SectorTerritorial getBy(Usuario usuario) {
        
        return this.dao.getAll().stream()
            .filter(x -> x.getUsuario().equals(usuario)).findFirst().orElse(null);
    }


    public SectorTerritorial getById( Integer id) {
        return this.dao.findOne(id);
    }

}