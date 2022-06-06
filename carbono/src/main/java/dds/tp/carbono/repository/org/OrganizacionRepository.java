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
}
