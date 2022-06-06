package dds.tp.carbono.services.organizacion;


import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.org.ContestadorSolicitudesRepository;

public abstract class ContestadorDeSolicitudesVinculacion {
    
    ContestadorSolicitudesRepository repository;

    public ContestadorDeSolicitudesVinculacion() {
        this.repository = new ContestadorSolicitudesRepository();
    }

    public abstract SolicitudVinculacion contestadorDeSolicitudes(SolicitudVinculacion solicitud) throws Exception;

}
