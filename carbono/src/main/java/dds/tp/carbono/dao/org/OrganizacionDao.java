package dds.tp.carbono.dao.org;


import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.Organizacion;

public class OrganizacionDao extends Dao<Organizacion> {

    private static OrganizacionDao instance;

    public static OrganizacionDao getInstance() {
        if (instance == null)
            instance = new OrganizacionDao();

        return instance;
    }
 
}
