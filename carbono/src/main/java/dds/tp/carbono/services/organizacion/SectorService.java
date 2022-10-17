package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.repository.organization.SectorRepository;

public class SectorService {
    public SectorRepository repository;

    public SectorService() {
        this.repository = new SectorRepository();
    }

     
    public Sector crear(Sector sector) throws Exception {
        return this.repository.guardar(sector);         
    }
    
    /*
    public SolicitudVinculacion getByUser(Usuario user) {
        return this.repository.getByUser(user);
    }
    */
    /*
    public List<SolicitudVinculacion> getAll() {
        return this.repository.getAll();
    }
    public SolicitudVinculacion getById(Integer id){
        return this.repository.getById(id);
    }
    */
   
}
