package dds.tp.carbono.repository.org;

import dds.tp.carbono.dao.org.CreadorDeOrganizacionesDao;
import dds.tp.carbono.entities.organization.Organizacion;

public class CreadorDeOrganizacionesRepository {

    CreadorDeOrganizacionesDao dao; 

    public CreadorDeOrganizacionesRepository() {
        this.dao = CreadorDeOrganizacionesDao.getInstance();
    }

    public Organizacion crear(Organizacion organizacion) {
        
        return this.dao.save(organizacion); 
        
    }
    
}
