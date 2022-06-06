package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.org.SolicitudVinculacionRepository;

public class ContestadorDeSolicitudesVinculacion {
    
    SolicitudVinculacionRepository repository;

    public ContestadorDeSolicitudesVinculacion() {
        this.repository = new SolicitudVinculacionRepository();
    }

    public SolicitudVinculacion aceptar(SolicitudVinculacion solicitud) throws Exception {
        SolicitudVinculacion solicitudEncontrada = this.repository.buscar(solicitud);

        
        if (solicitudEncontrada.getEstado() == EstadoSolicitudVinculacion.ACEPTADO)
            throw new Exception("Solicitud ya estaba Aceptada");

        return this.repository.editarEstado(solicitudEncontrada, EstadoSolicitudVinculacion.ACEPTADO);
    }

    public SolicitudVinculacion rechazar(SolicitudVinculacion solicitud) throws Exception {
        SolicitudVinculacion solicitudEncontrada = this.repository.buscar(solicitud);


        if (solicitudEncontrada.getEstado() == EstadoSolicitudVinculacion.RECHAZADO)
            throw new Exception("Solicitud ya estaba Rechazada");

        return this.repository.editarEstado(solicitudEncontrada, EstadoSolicitudVinculacion.RECHAZADO);
    }
}
