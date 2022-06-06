package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.Organizacion;

import dds.tp.carbono.repository.org.OrganizacionRepository;

public class CreadorDeOrganizacion {

    private OrganizacionRepository repository;

    public CreadorDeOrganizacion() {
        this.repository = new OrganizacionRepository();
    }

    public Organizacion crear(Organizacion organizacion) {
        return this.repository.guardar(organizacion);         
    }
}