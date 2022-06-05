package dds.tp.carbono.repository;

import dds.tp.carbono.entities.organization.Organizacion;

public class OrganizacionRepository extends Repository<Organizacion> {
    
    private static OrganizacionRepository instance;

    public static OrganizacionRepository getInstance() {
        if (instance == null)
            instance = new OrganizacionRepository();

        return instance;
    }

    @Override
    public Organizacion save(Organizacion org) {
        org = super.save(org);
        
        PuntoGeograficoRepository.getInstance().save(org.getUbicacion());

        return org;
    }

    @Override
    public Organizacion setId(Integer id, Organizacion item) {
        item.setId(id);
        return item;
    }
}
