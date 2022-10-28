package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class RequestDao extends Dao<SolicitudVinculacion> {
    private static RequestDao instance;

    public static RequestDao getInstance() {
        if (instance == null)
            instance = new RequestDao();

        return instance;
    }
}
