package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.organization.Organizacion;

public class CreadorDeOrganizacionesDao extends Dao<Organizacion> {

    private static CreadorDeOrganizacionesDao instance;

    public static CreadorDeOrganizacionesDao getInstance() {
        if (instance == null)
            instance = new CreadorDeOrganizacionesDao();

        return instance;
    }

    private int idCounter = 0;

    @Override
    public Organizacion setId(Integer id, Organizacion item) {
        item.setId(idCounter++);
        return item;
    }
    
}
