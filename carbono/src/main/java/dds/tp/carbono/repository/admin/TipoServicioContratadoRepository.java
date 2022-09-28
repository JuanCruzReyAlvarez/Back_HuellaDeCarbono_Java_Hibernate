package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.TipoServicioContratadoDao;
import dds.tp.carbono.entities.transport.TipoServicioContratado;

public class TipoServicioContratadoRepository {

    private TipoServicioContratadoDao dao;
   

    public TipoServicioContratadoRepository() {
        this.dao = TipoServicioContratadoDao.getInstance();
        this.dao.setClazz(TipoServicioContratado.class);
    }
    
    public TipoServicioContratado guardar(TipoServicioContratado servicio) {
        return this.dao.save(servicio);
    }

    public boolean existe(String nombre) {
        return this.dao.getAll().stream().anyMatch(servicio -> servicio.getNombre().equals(nombre));
    }
}
