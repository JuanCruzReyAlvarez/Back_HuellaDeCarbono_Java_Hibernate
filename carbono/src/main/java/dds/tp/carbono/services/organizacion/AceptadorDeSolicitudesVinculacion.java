package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class AceptadorDeSolicitudesVinculacion extends ContestadorDeSolicitudesVinculacion {
    

    @Override
    public SolicitudVinculacion contestadorDeSolicitudes(SolicitudVinculacion solicitud) throws Exception {
        if (this.repository.existsSolicitud(solicitud))
            throw new Exception("La solicitud no existe");

        if(solicitud.getEstado() == EstadoSolicitudVinculacion.ACEPTADO)
            throw new Exception("La solicitud ya fue aceptada");
        
        return this.repository.modificarEstado(solicitud, EstadoSolicitudVinculacion.ACEPTADO);
    }

}
    

