package dds.tp.carbono.repository.organization;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.org.SectorDao;
import dds.tp.carbono.entities.organization.Sector;

public class SectorRepository {

    private SectorDao dao; 

    public SectorRepository() {
        this.dao = SectorDao.getInstance();
        this.dao.setClazz(Sector.class);
    }

    public Sector guardar(Sector sector) {
        return this.dao.save(sector); 
    }
/* 
    public boolean exists(Integer id) {
        return this.dao.getAll().stream().anyMatch(o -> o.getId(id).equals(razonSocial));
    }
*/
/* 
    public SolicitudVinculacion getByUser(Usuario user) {
        return this.dao.getAll().stream().filter(o -> o.getUser().equals(user)).findFirst().orElse(null);
    }  
*/
/*
    public List<SolicitudVinculacion> getAll() {
        return this.dao.getAll();
    }
    public SolicitudVinculacion getById(Integer id) {
        return this.dao.findOne(id);
    }
*/

    public Sector getByName(String nombre) {
        return (Sector) this.dao.getAll().stream().filter(o -> o.getNombre().equals(nombre));
    }

    public Sector getById(Integer id) {
        return this.dao.findOne(id);
    }

    public List<Sector> getByOrg(int id) {
        return this.dao.getAll().stream().filter(s -> s.getOrganizacion().getId().equals(id)).collect(Collectors.toList());
    }
}
