package dds.tp.carbono.dao.PuntoGeografico;
import java.util.List;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.services.external.dto.Pais;


public class PaisDao extends Dao<Pais>{

    
    private static PaisDao instance;

    public List<Pais> getAll() {
        return null;
    }

	 public static PaisDao getInstance() {
        if (instance == null)
            instance = new PaisDao();

        return instance;
    }
 


}
