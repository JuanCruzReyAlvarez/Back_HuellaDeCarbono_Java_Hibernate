package dds.tp.carbono.repository.organization;

import java.util.List;

import dds.tp.carbono.dao.org.RequestDao;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class RequestRepository {
    private RequestDao dao; 

    public RequestRepository() {
        this.dao = RequestDao.getInstance();
        this.dao.setClazz(SolicitudVinculacion.class);
    }

    public SolicitudVinculacion guardar(SolicitudVinculacion organizacion) {
        return this.dao.save(organizacion); 
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
    public List<SolicitudVinculacion> getAll() {
        return this.dao.getAll();
    }
    public SolicitudVinculacion getById(Integer id) {
        return this.dao.findOne(id);
    }
    public void update(SolicitudVinculacion sol) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(sol.getEstado());
        this.dao.update(sol);
    }
}
