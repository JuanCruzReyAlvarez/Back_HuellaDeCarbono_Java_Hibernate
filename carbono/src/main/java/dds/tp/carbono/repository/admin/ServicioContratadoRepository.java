package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.ServicioContratadoDao;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.transport.ServicioContratado;

public class ServicioContratadoRepository {

    private ServicioContratadoDao dao;
   

    public ServicioContratadoRepository() {
        this.dao = ServicioContratadoDao.getInstance();
        this.dao.setClazz(ServicioContratado.class);
    }
    
    public void guardar(ServicioContratado servicio) {
         this.dao.save(servicio);
    }

    public boolean existe(String nombre) {
        return this.dao.getAll().stream().anyMatch(servicio -> servicio.getTipo().getNombre().equals(nombre));
    }
    public boolean existeEmpresaConEsteCombustible(String nombre, TipoDeConsumo Combustible) {
        return this.dao.getAll().stream().anyMatch(servicio -> servicio.getTipo().getNombre().equals(nombre) 
                                                                && servicio.getCombustible().equals(Combustible));
    }
    
                                                                                                                       
}
