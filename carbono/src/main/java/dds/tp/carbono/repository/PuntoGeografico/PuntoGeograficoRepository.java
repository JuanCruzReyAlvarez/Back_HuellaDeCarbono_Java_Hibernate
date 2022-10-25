package dds.tp.carbono.repository.PuntoGeografico;
import java.util.List;

import dds.tp.carbono.dao.member.PuntoGeograficoDao;
import dds.tp.carbono.entities.point.PuntoGeografico;


public class PuntoGeograficoRepository {

    private PuntoGeograficoDao dao;

    
    public PuntoGeograficoRepository() {
        this.dao = PuntoGeograficoDao.getInstance();
        this.dao.setClazz(PuntoGeografico.class);
    }

    public List<PuntoGeografico> getAll() {
        return this.dao.getAll();
    }

    public void saveAll(List<PuntoGeografico> puntoGeografico) {
       this.dao.saveAll(puntoGeografico);
    }

    public void saveOne(PuntoGeografico puntoGeografico) {
        this.dao.save(puntoGeografico);
     }

}