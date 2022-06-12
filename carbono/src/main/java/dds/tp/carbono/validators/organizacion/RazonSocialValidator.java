package dds.tp.carbono.validators.organizacion;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.organization.OrganizacionRepository;

public class RazonSocialValidator implements OrganizacionValidatorCommand {

    private OrganizacionRepository repository;

    public RazonSocialValidator() {
        repository = new OrganizacionRepository();
    }

    @Override
    public Boolean validate(Organizacion organizacion) {
        return !this.repository.exists(organizacion.getRazonSocial()) && organizacion.getRazonSocial() != null;
    }
}
