package dds.tp.carbono.services.external.puntoGeografico;

import java.util.List;

import dds.tp.carbono.repository.PuntoGeografico.LocalidadRepository;
import dds.tp.carbono.services.external.dto.Localidad;

public class LocalidadService {
    

    private LocalidadRepository repository;

    public LocalidadService() {
        this.repository = new LocalidadRepository();
    }

    
    public List<Localidad> getAll() {
        return this.repository.getAll();
    }
   
    public void saveAll(List<Localidad> localidad) {
        this.repository.saveAll(localidad);
    }


    public List<Localidad> getById(Integer idMunicipio) {

        return this.repository.getById(idMunicipio);
    }

}

