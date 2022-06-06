package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.organization.Organizacion;

import dds.tp.carbono.repository.org.CreadorDeOrganizacionesRepository;

public class CreadorDeOrganizacion {

    private CreadorDeOrganizacionesRepository repository;

    public CreadorDeOrganizacion() {
        this.repository = new CreadorDeOrganizacionesRepository();
    }

    public Organizacion crear(Organizacion organizacion) {
        
        return this.repository.crear(organizacion); 
        
    }
    

  
}


