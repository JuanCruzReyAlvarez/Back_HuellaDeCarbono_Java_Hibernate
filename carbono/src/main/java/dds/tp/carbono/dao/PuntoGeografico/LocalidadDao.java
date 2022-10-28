package dds.tp.carbono.dao.PuntoGeografico;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.dao.Dao;

public class LocalidadDao extends Dao<Localidad>{

    
    private static LocalidadDao instance;

	public static LocalidadDao getInstance() {
        if (instance == null)
            instance = new LocalidadDao();

        return instance;
    }

    public List<Localidad> getById(Integer idMunicipio) {
        return getAll().stream().filter(l -> l.getMunicipio().getId().equals(idMunicipio)).collect(Collectors.toList());

 
    }
}

 

