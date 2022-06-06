package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.org.AceptadorSolicitudesRepository;

public class AceptadorDeSolicitudesVinculacion {
    
    AceptadorSolicitudesRepository repository;

    public AceptadorDeSolicitudesVinculacion() {
        this.repository = new AceptadorSolicitudesRepository();
    }

    public SolicitudVinculacion aceptadorVinculacion(SolicitudVinculacion solicitud) throws Exception {
        if (this.repository.existsSolicitud(solicitud))
            throw new Exception("La solicitud no existe");
      
        return this.repository.modificarEstado(solicitud);        
    }
}
