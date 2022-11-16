package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.transport.VehiculoParticular;

public class TransporteParticularDao extends Dao<VehiculoParticular>{
    private static TransporteParticularDao instance;

    public static TransporteParticularDao getInstance() {
        if (instance == null)
            instance = new TransporteParticularDao();
        return instance;
    }
}
