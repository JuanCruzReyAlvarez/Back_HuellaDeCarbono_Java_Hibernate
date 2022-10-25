package dds.tp.carbono.repository.PuntoGeografico;

import java.util.List;

import dds.tp.carbono.dao.PuntoGeografico.LocalidadDao;
import dds.tp.carbono.services.external.dto.Localidad;

public class LocalidadRepository {
    private LocalidadDao dao;

    
    public LocalidadRepository() {
        this.dao = LocalidadDao.getInstance();
        this.dao.setClazz(Localidad.class);
    }

    public List<Localidad> getAll() {
        return this.dao.getAll();
    }

    public void saveAll(List<Localidad> localidad) {
        this.dao.saveAll(localidad);;
     }

    public List<Localidad> getById(Integer idMunicipio) {
        return this.dao.getById(idMunicipio);
    }

}
