package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.organization.OrganizacionRepository;

public class CreadorDeOrganizacion {

    private OrganizacionRepository repository;

    public CreadorDeOrganizacion() {
        this.repository = new OrganizacionRepository();
    }

    public Organizacion crear(Organizacion organizacion) throws Exception {

        if (!organizacion.isValid())
            throw new Exception("Invalid Organization");

        return this.repository.guardar(organizacion);         
    }
}