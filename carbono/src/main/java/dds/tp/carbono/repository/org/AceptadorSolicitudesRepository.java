package dds.tp.carbono.repository.org;


import dds.tp.carbono.dao.org.SolicitudVinculacionDao;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class AceptadorSolicitudesRepository {

    SolicitudVinculacionDao dao; 

    public AceptadorSolicitudesRepository() {
        this.dao = SolicitudVinculacionDao.getInstance();
    }

    public boolean existsSolicitud(SolicitudVinculacion solicitud ) {
        return this.dao.getAll()
                        .contains(solicitud);
                        
    }

    public SolicitudVinculacion modificarEstado(SolicitudVinculacion solicitud) {
        

        return this.dao.save(solicitud); 
    }
    
}
