package dds.tp.carbono.repository.org;

import dds.tp.carbono.dao.org.CreadorDeOrganizacionesDao;
import dds.tp.carbono.entities.organization.Organizacion;

public class OrganizacionRepository {

    CreadorDeOrganizacionesDao dao; 

    public OrganizacionRepository() {
        this.dao = CreadorDeOrganizacionesDao.getInstance();
    }

    public Organizacion guardar(Organizacion organizacion) {
        return this.dao.save(organizacion); 
    }

    public boolean exists(String razonSocial) {
        return this.dao.getAll().stream().anyMatch(o -> o.getRazonSocial().equals(razonSocial));
    }    
}
