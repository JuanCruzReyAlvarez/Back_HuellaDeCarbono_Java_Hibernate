package dds.tp.carbono.dao.PuntoGeografico;
import java.util.List;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.services.external.dto.Municipio;


public class MunicipioDao extends Dao<Municipio>{

    
    private static MunicipioDao instance;

    public List<Municipio> getAll() {
        return null;
    }

	 public static MunicipioDao getInstance() {
        if (instance == null)
            instance = new MunicipioDao();

        return instance;
    }
 


}
    

