package dds.tp.carbono.services.external.puntoGeografico;

import java.util.List;

import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.services.external.dto.Provincia;

public class ProvinciaService {
        private ProvinciaRepository repository;

    public ProvinciaService() {
        this.repository = new ProvinciaRepository();
    }
    
    public List<Provincia> getAll() {
        return this.repository.getAll();
    }

    public void saveAll(List<Provincia> provincias) {
        
        this.repository.saveAll(provincias);
    }
    public Provincia getById(Integer id) {
        return this.repository.getByIdProvincia(id);
    }


   

}
