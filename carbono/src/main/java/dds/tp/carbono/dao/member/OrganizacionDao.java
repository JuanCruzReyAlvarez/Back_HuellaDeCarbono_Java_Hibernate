package dds.tp.carbono.dao.member;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;

public class OrganizacionDao extends Dao<Organizacion> {
    
    private int idCount = 0;
    private static OrganizacionDao instance;

    public static OrganizacionDao getInstance() {
        if (instance == null)
            instance = new OrganizacionDao();

        return instance;
    }

    public List<Sector> getSectores() {
        List<Sector> sectores = new ArrayList<Sector>();
        this.getAll()
            .stream()
            .map(o -> o.getSectores())
            .forEach(ls -> ls.forEach(sector -> sectores.add(sector)));
        
        return sectores;
    }

    @Override
    public Organizacion save(Organizacion org) {
        org = super.save(org);
        
        PuntoGeograficoDao.getInstance().save(org.getUbicacion());

        return org;
    }

    @Override
    public Organizacion setId(Integer id, Organizacion item) {
        item.setId(idCount++);
        return item;
    }
}
