package dds.tp.carbono.dao.member;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.dao.Dao;

public class PuntoGeograficoDao extends Dao<PuntoGeografico> {
    
    private static PuntoGeograficoDao instance;

    public static PuntoGeograficoDao getInstance() {
        if (instance == null)
            instance = new PuntoGeograficoDao();

        return instance;
    }


}
