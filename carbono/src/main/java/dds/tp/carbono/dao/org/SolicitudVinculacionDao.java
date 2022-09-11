package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class SolicitudVinculacionDao extends Dao<SolicitudVinculacion> {

    private static SolicitudVinculacionDao instance;

    public static SolicitudVinculacionDao getInstance() {
        if (instance == null)
            instance = new SolicitudVinculacionDao();

        return instance;
    }

    @Override
    public SolicitudVinculacion setId(Integer id, SolicitudVinculacion item) {
        item.setId(id);
        return item;
    }    
}
