package dds.tp.carbono.validators.organizacion;

import dds.tp.carbono.entities.organization.Organizacion;

public class ClasificacionValidator implements OrganizacionValidatorCommand {

    @Override
    public Boolean validate(Organizacion organziacion) {
        return organziacion.getClasificacion() != null;
    }
    
}
