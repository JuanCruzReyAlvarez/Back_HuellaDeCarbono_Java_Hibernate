package dds.tp.carbono.repository.PuntoGeografico;

import java.util.List;
import dds.tp.carbono.dao.PuntoGeografico.MunicipioDao;
import dds.tp.carbono.services.external.dto.Municipio;

public class MunicipioRepository {
    private MunicipioDao dao;

    public MunicipioRepository() {
        this.dao = MunicipioDao.getInstance();
        this.dao.setClazz(Municipio.class);
    }
    
    public List<Municipio> getAll() {
        return this.dao.getAll();
    }
    public void saveAll(List<Municipio> municipio) {
        this.dao.saveAll(municipio);;
     }
}
