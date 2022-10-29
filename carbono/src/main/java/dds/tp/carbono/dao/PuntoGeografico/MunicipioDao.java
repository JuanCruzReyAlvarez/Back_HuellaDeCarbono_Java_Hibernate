package dds.tp.carbono.dao.PuntoGeografico;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.services.external.dto.Municipio;


public class MunicipioDao extends Dao<Municipio>{

    private static MunicipioDao instance;

	 public static MunicipioDao getInstance() {
        if (instance == null)
            instance = new MunicipioDao();

        return instance;
    }
    
    public List<Municipio> getByIdProvincia(Integer id) {
        return getAll().stream().filter(m->m.getProvincia().getId().equals(id)).collect(Collectors.toList());
 
    }
    public Integer getIdByName(String name) {
        System.out.println(name);
        return getAll().stream().filter(l -> l.getNombre().
                                               contains(name) ).
                                               collect(Collectors.toList())
                                               .get(0)
                                               .getId();   
}

}
    

