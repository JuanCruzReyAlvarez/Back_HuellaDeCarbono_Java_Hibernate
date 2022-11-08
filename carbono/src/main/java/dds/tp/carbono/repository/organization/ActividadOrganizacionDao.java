package dds.tp.carbono.repository.organization;


import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.metrics.Actividad;

public class ActividadOrganizacionDao extends Dao<Actividad> {
    
    private static ActividadOrganizacionDao instance;

    public static ActividadOrganizacionDao getInstance() {
        if (instance == null)
            instance = new ActividadOrganizacionDao();

        return instance;
    }

    public Actividad getActividadOrganizacion(Integer idActOrg){
        return findOne(idActOrg);
    }

}
