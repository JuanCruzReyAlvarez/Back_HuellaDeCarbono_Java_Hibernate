package dds.tp.carbono.dao.member;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.member.Tramo;

public class TramoRepositoryDao extends Dao<Tramo> {

        private static TramoRepositoryDao instance;

    public static TramoRepositoryDao getInstance() {
        if (instance == null)
            instance = new TramoRepositoryDao();

        return instance;
    }
}
