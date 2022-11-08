package dds.tp.carbono.services;

import java.util.List;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.repository.member.MiembroRepository;

public class MiembroService {
    
    private MiembroRepository repository;

    public MiembroService() {
        this.repository = new MiembroRepository();
    }

    public Miembro getById(Integer id) {
        return this.repository.getById(id);
    }
    public Miembro getByUserId(Integer id) {
        return this.repository.getByUserId(id);
    }
    

    public List<Miembro> getByOrg(int id) {
        return this.repository.getByOrg(id);
    }

    public List<Miembro> getAll() {
        return this.repository.getAll();
    }
}


