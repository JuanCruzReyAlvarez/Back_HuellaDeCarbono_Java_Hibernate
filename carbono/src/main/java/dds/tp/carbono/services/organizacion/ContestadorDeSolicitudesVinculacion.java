package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.org.SolicitudVinculacionRepository;

public class ContestadorDeSolicitudesVinculacion {
    
    ContestadorDeSolicitudesVinculacion repository;

    public ContestadorDeSolicitudesVinculacion() {
        this.repository = new ContestadorDeSolicitudesVinculacion();
    }

    public SolicitudVinculacion contestarSolicitud(Solicitud solicitud, EstadoSolicitudVinculacion estado) throws Exception {
        if (this.repository.existsSolicitud(miembro, sector))
            throw new Exception("Solicitud a estaba Pendiente/Aceptada");

        SolicitudVinculacion solicitud = new SolicitudVinculacion(miembro, sector);
        
        return this.repository.determinarEstado(solicitud);        
    }
}