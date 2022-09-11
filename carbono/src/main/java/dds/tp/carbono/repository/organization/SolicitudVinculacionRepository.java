package dds.tp.carbono.repository.organization;

import java.util.NoSuchElementException;

import dds.tp.carbono.dao.org.SolicitudVinculacionDao;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class SolicitudVinculacionRepository {

    SolicitudVinculacionDao dao; 

    public SolicitudVinculacionRepository() {
        this.dao = SolicitudVinculacionDao.getInstance();
    }

    public boolean existsSolicitud(Miembro miembro, Sector sector) {
        return this.dao.getAll()
                        .stream()
                        .anyMatch(solicitud -> solicitud.getMiembro().equals(miembro) 
                                                            && solicitud.getSector().equals(sector)
                                                            && (solicitud.getEstado().equals(EstadoSolicitudVinculacion.PENDIENTE)
                                                            || solicitud.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO)));
    }

    public SolicitudVinculacion crearSolicitud(SolicitudVinculacion solicitud) {
        return this.dao.save(solicitud);
    }

    public SolicitudVinculacion buscar(SolicitudVinculacion solicitud) throws NoSuchElementException {
        SolicitudVinculacion solicitudEncontrada = this.dao.getAll()
                                                            .stream()
                                                            .filter(s -> s.getId().equals(solicitud.getId()))
                                                            .findFirst()
                                                            .orElse(null);
        if (solicitudEncontrada != null)
            return solicitudEncontrada;
        
        throw new NoSuchElementException();
    }

    public SolicitudVinculacion editarEstado(SolicitudVinculacion solicitud, EstadoSolicitudVinculacion estado) {
        int index = this.dao.getAll().indexOf(solicitud);
        this.dao.getAll().get(index).setEstado(estado);
        return this.dao.getAll().get(index);
    }
}
