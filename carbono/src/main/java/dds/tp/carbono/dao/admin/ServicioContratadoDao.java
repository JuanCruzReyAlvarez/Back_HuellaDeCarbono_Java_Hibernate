package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.transport.ServicioContratado;

public class ServicioContratadoDao extends Dao<ServicioContratado> {

    private static ServicioContratadoDao instance;

    
    
    public static ServicioContratadoDao getInstance() {
        if (instance == null)
            instance = new ServicioContratadoDao();
        return instance;
    }

 
}
