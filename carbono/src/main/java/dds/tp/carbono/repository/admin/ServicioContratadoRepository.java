package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.ServicioContratadoDao;
import dds.tp.carbono.entities.transport.ServicioContratado;
import dds.tp.carbono.entities.transport.TipoServicioContratado;

public class ServicioContratadoRepository {

    private ServicioContratadoDao dao;

    public ServicioContratadoRepository() {
        this.dao = ServicioContratadoDao.getInstance();
    }
    
    public ServicioContratado guardar(ServicioContratado servicio) {
        return this.dao.save(servicio);
    }

    public boolean isValidServicioContratado(Integer id, TipoServicioContratado tipo) {
        return this.dao.getAll().stream().anyMatch(servicio -> servicio.getId().equals(id));
    }
    
}
