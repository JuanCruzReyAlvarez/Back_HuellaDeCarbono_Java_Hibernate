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
    
    public SolicitudVinculacion setEstado(EstadoSolicitudVinculacion estado, SolicitudVinculacion item) {
        item.setEstado(estado);
        return item;
    }

    @Override
    public SolicitudVinculacion save(SolicitudVinculacion item) {
        this.setId(this.lista.size() + 1, item); // como accedo a la lista del dao, no la estoy overrideando en realidad 
        this.setEstado(, item);        
        this.lista.add(item);
        return item;
    }
    

    
    
}
