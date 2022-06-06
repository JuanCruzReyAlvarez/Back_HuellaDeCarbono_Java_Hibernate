package dds.tp.carbono.dao.org;
import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class AceptadorSolicitudesDao extends Dao<SolicitudVinculacion> {

    private static AceptadorSolicitudesDao instance;

    public static AceptadorSolicitudesDao getInstance() {
        if (instance == null)
            instance = new AceptadorSolicitudesDao();

        return instance;
    }

    private int idCounter = 0;

    @Override
    public SolicitudVinculacion setId(Integer id, SolicitudVinculacion item) {
        // TODO Auto-generated method stub
        return null;
    }
    
    

    
}