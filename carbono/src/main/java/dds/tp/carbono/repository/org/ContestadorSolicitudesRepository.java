package dds.tp.carbono.repository.org;


import dds.tp.carbono.dao.org.ContestadorSolicitudDao;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class ContestadorSolicitudesRepository {

    ContestadorSolicitudDao dao; 

    public ContestadorSolicitudesRepository() {
        this.dao = ContestadorSolicitudDao.getInstance();
    }

    public boolean existsSolicitud(SolicitudVinculacion solicitud ) {
        return this.dao.getAll()
                        .contains(solicitud);
                        
    }

    public SolicitudVinculacion modificarEstado(SolicitudVinculacion solicitud, EstadoSolicitudVinculacion estado) {
    
        this.dao.moficicarEstado(estado, solicitud);
                
        
    return this.dao.save(solicitud); 
    }
    
}
