package dds.tp.carbono.services.organizacion;

import java.util.List;

import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.organization.RequestRepository;

public class RequestService {
    public RequestRepository repository;

    public RequestService() {
        this.repository = new RequestRepository();
    }

    /* 
    public SolicitudVinculacion crear(SolicitudVinculacion organizacion) throws Exception {

        if (!SolicitudVinculacion.isValid())
            throw new Exception("Invalid Organization");

        return this.repository.guardar(organizacion);         
    }
    */
    /*
    public SolicitudVinculacion getByUser(Usuario user) {
        return this.repository.getByUser(user);
    }
    */
    public List<SolicitudVinculacion> getAll() {
        return this.repository.getAll();
    }
    public SolicitudVinculacion getById(Integer id){
        return this.repository.getById(id);
    }
    public void update(SolicitudVinculacion sol){
        this.repository.update(sol);
    }
    public void save(SolicitudVinculacion sol){
        this.repository.guardar(sol);
    }
   

}
