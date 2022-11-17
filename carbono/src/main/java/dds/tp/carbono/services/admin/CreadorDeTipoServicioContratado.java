/*
package dds.tp.carbono.services.admin;

import dds.tp.carbono.entities.transport.TipoServicioContratado;
import dds.tp.carbono.repository.admin.ServicioContratadoRepository;

//Es un service no es de nuestro dominio, esta bien el acceso al repository.

public class CreadorDeTipoServicioContratado {
    
    private ServicioContratadoRepository repository;

    public CreadorDeTipoServicioContratado() {
        this.repository = new ServicioContratadoRepository();
    }

    public TipoServicioContratado crear(String nombre) throws Exception {
        if (!this.repository.existe(nombre))
            return this.repository.guardar(new TipoServicioContratado(nombre));

        throw new Exception("Tipo de servicio contratado ya existe");
    }
}
 */
