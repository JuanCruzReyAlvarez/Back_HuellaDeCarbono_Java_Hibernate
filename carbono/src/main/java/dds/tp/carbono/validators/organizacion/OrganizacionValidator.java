package dds.tp.carbono.validators.organizacion;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;

public class OrganizacionValidator {
    
    private List<OrganizacionValidatorCommand> commands;

    public OrganizacionValidator() {
        this.commands = new ArrayList<OrganizacionValidatorCommand>() {{
            add(new RazonSocialValidator());
        }};
    }

    public Boolean validate(Organizacion organizacion) {
        return this.commands.stream().allMatch(v -> v.validate(organizacion));
    }
}
