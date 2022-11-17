package dds.tp.carbono.repository.member;

import dds.tp.carbono.dao.member.TramoRepositoryDao;
import dds.tp.carbono.entities.member.Tramo;

public class TramoRepository {

    private TramoRepositoryDao dao;
 
    public TramoRepository() {
        this.dao = TramoRepositoryDao.getInstance();
        this.dao.setClazz(Tramo.class);
    }

    public Tramo guardar(Tramo tramo) {
        return this.dao.save(tramo);
    }
}
