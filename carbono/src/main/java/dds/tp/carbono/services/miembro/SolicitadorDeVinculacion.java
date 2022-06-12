package dds.tp.carbono.services.miembro;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.organization.SolicitudVinculacionRepository;

public class SolicitadorDeVinculacion {
    
    SolicitudVinculacionRepository repository;

    public SolicitadorDeVinculacion() {
        this.repository = new SolicitudVinculacionRepository();
    }

    public SolicitudVinculacion solicitarVinculacion(Miembro miembro, Sector sector) throws Exception {
        if (this.repository.existsSolicitud(miembro, sector))
            throw new Exception("Solicitud a estaba Pendiente/Aceptada");

        SolicitudVinculacion solicitud = new SolicitudVinculacion(miembro, sector);
        
        return this.repository.crearSolicitud(solicitud);        
    }
}
