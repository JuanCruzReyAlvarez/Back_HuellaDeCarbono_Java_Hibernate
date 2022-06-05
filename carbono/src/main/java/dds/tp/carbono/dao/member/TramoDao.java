package dds.tp.carbono.dao.member;

import dds.tp.carbono.repository.TrayectoRepository;

public class TramoDao {
    private TrayectoRepository repository;

    public TramoDao() {
        this.repository = TrayectoRepository.getInstance();
    }

}
