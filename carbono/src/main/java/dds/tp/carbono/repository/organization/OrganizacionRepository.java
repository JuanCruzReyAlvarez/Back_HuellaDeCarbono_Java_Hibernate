package dds.tp.carbono.repository.organization;

import dds.tp.carbono.dao.organization.OrganizacionDao;
import dds.tp.carbono.entities.organization.Organizacion;

public class OrganizacionRepository {

    OrganizacionDao dao; 

    public OrganizacionRepository() {
        this.dao = OrganizacionDao.getInstance();
    }

    public Organizacion guardar(Organizacion organizacion) {
        return this.dao.save(organizacion); 
    }

    public boolean exists(String razonSocial) {
        return this.dao.getAll().stream().anyMatch(o -> o.getRazonSocial().equals(razonSocial));
    }    
}
