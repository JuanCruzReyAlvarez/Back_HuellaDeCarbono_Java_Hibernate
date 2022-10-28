
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
        return this.dao.getAll();
    }

    public void saveAll(List<Provincia> provincias) {
       
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA 4.5");

        for (Provincia provincia: provincias){
            
             System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA44 555 ");
            this.dao.save(provincia);
            System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA44 777 ");
        }


       //this.dao.saveAll(provincias);;
    }

    public void saveOne(Provincia provincia) {
        this.dao.save(provincia);
     }
    public Provincia getByIdProvincia(Integer id){
        return this.dao.findOne(id);
    }
}


