package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class ContestadorSolicitudDao extends Dao<SolicitudVinculacion> {

    private static ContestadorSolicitudDao instance;

    public static ContestadorSolicitudDao getInstance() {
        if (instance == null)
            instance = new ContestadorSolicitudDao();

        return instance;
    }

    private int idCounter = 0;
    
    
    @Override
    public SolicitudVinculacion setId(Integer id, SolicitudVinculacion item) {
        item.setId(idCounter++);
        return item;
    }
    
    public void moficicarEstado(EstadoSolicitudVinculacion estado, SolicitudVinculacion item) {
        item.setEstado(estado);
    }

    



    

    
    
}
