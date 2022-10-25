package dds.tp.carbono.services.external.puntoGeografico;

import java.util.List;

import dds.tp.carbono.repository.PuntoGeografico.MunicipioRepository;
import dds.tp.carbono.services.external.dto.Municipio;

public class MunicipioService {

    private MunicipioRepository repository;

    public MunicipioService() {
        this.repository = new MunicipioRepository();
    }

    
    public List<Municipio> getAll() {
        return this.repository.getAll();
    }
   

    public void SaveAll(List<Municipio> municipio) {
        this.repository.saveAll(municipio);
    }


    public List<Municipio> getById(Integer id) {
        return this.repository.getByIdProvincia(id);
    }
    
}
