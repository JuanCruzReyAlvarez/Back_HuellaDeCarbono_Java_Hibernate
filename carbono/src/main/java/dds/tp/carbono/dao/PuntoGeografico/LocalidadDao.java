package dds.tp.carbono.dao.PuntoGeografico;

import java.util.List;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.dao.member.Dao;

public class LocalidadDao extends Dao<Localidad>{

    
    private static LocalidadDao instance;

    public List<Localidad> getAll() {
        return null;
    }

	 public static LocalidadDao getInstance() {
        if (instance == null)
            instance = new LocalidadDao();

        return instance;
    }
 
}
