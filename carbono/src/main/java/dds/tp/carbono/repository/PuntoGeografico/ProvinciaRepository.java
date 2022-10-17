
package dds.tp.carbono.repository.PuntoGeografico;

import java.util.List;

import dds.tp.carbono.dao.PuntoGeografico.ProvinciaDao;
import dds.tp.carbono.services.external.dto.Provincia;

public class ProvinciaRepository {
   
    private ProvinciaDao dao;

    
    public ProvinciaRepository() {
        this.dao = ProvinciaDao.getInstance();
        this.dao.setClazz(Provincia.class);
    }

      public List<Provincia> getAll() {
        //return this.dao.getAll();
        return this.dao.buscarTodos();
    }

    public void saveAll(List<Provincia> provincias) {
       this.dao.saveAll(provincias);;
    }

    public void saveOne(Provincia provincia) {
        this.dao.save(provincia);
     }
}


