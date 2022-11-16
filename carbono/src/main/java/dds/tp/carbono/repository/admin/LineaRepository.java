package dds.tp.carbono.repository.admin;

import java.util.List;

import dds.tp.carbono.dao.admin.LineaRepositoryDao;
import dds.tp.carbono.entities.transport.Linea;

public class LineaRepository {
    private LineaRepositoryDao dao;
   

    public LineaRepository() {
        this.dao = LineaRepositoryDao.getInstance();
        this.dao.setClazz(Linea.class);
    }
    
    public void save(Linea linea) {
        this.dao.save(linea);
    }

    public Linea getById(Integer id) {
        return this.dao.findOne(id);
    }

    public List<Linea> getAll() {
        return this.dao.getAll();
    }
}
