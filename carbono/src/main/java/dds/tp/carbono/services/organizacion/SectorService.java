package dds.tp.carbono.services.organizacion;

import java.util.List;

import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.repository.organization.SectorRepository;

public class SectorService {
    public SectorRepository repository;

    public SectorService() {
        this.repository = new SectorRepository();
    }

    public void save(Sector sector){
        repository.guardar(sector);
    }

     
    public Sector crear(Sector sector) throws Exception {
        return this.repository.guardar(sector);         
    }

    public Sector getByName(String nombre){
        return this.repository.getByName(nombre);
    }


    public List<Sector> getByOrg(int id) {
        return this.repository.getByOrg(id);
    }
    
    /*
    public SolicitudVinculacion getByUser(Usuario user) {
        return this.repository.getByUser(user);
    }
    */
    /*
    public List<SolicitudVinculacion> getAll() {
        return this.repository.getAll();
    }*/
    public Sector getById(Integer id){
        return this.repository.getById(id);
    }
    
   
}
