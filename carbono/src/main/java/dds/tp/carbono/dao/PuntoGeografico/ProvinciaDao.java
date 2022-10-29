package dds.tp.carbono.dao.PuntoGeografico;

import java.util.stream.Collectors;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.services.external.dto.Provincia;

public class ProvinciaDao extends Dao<Provincia>{
    
    private static ProvinciaDao instance;

	 public static ProvinciaDao getInstance() {
        if (instance == null)
            instance = new ProvinciaDao();

        return instance;
    }
    public Integer getIdByName(String name){
        return getAll().stream().filter(l -> l.getNombre().
                                               contains(name) ).
                                               collect(Collectors.toList())
                                               .get(0)
                                               .getId();
    }

}
    

