package dds.tp.carbono.services.organizacion;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.organization.OrganizacionRepository;

public class OrganizacionService {

    private OrganizacionRepository repository;

    public OrganizacionService() {
        this.repository = new OrganizacionRepository();
    }

    public Organizacion crear(Organizacion organizacion) throws Exception {

        if (!organizacion.isValid())
            throw new Exception("Invalid Organization");

        return this.repository.guardar(organizacion);         
    }

    public Organizacion getByUser(Usuario user) {
        return this.repository.getByUser(user);
    }
}