package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.transport.MedioNoMotorizado;

public class TransporteNoMotorizadoDao extends Dao<MedioNoMotorizado> {
    
    private static TransporteNoMotorizadoDao instance; 
    
    public static TransporteNoMotorizadoDao getInstance() {
        if (instance == null)
            instance = new TransporteNoMotorizadoDao();
        return instance;
    }

}
