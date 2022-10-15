package dds.tp.carbono.dao.PuntoGeografico;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.services.external.dto.Provincia;

public class ProvinciaDao extends Dao<Provincia>{
    
    private static ProvinciaDao instance;

	 public static ProvinciaDao getInstance() {
        if (instance == null)
            instance = new ProvinciaDao();

        return instance;
    }

}
    

