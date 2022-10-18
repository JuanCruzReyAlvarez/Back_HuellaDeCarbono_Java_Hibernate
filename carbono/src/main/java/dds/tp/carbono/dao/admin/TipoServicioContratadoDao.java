package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.transport.TipoServicioContratado;

public class TipoServicioContratadoDao extends Dao<TipoServicioContratado> {

    private static TipoServicioContratadoDao instance;

    
    
    public static TipoServicioContratadoDao getInstance() {
        if (instance == null)
            instance = new TipoServicioContratadoDao();
        return instance;
    }

 
}
