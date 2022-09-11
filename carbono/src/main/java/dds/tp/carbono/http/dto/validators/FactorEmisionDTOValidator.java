package dds.tp.carbono.http.dto.validators;

import dds.tp.carbono.http.dto.admin.FactorEmisionDTO;
import dds.tp.carbono.http.validator.ValidateResult;
import dds.tp.carbono.http.validator.Validator;

public class FactorEmisionDTOValidator extends Validator<FactorEmisionDTO> {
    private static final String REQUIRED_MESSAGE = "The %s field is required";

    @Override
    public ValidateResult validate(FactorEmisionDTO dto) {
        if (dto.getActividad() == null || dto.getActividad().isEmpty())
            addError("actividad", String.format(REQUIRED_MESSAGE, "actividad"));
        
        if (dto.getTipoConsumo() == null || dto.getTipoConsumo().isEmpty())
            addError("tipoConsumo", String.format(REQUIRED_MESSAGE, "tipoConsumo"));

        if (dto.getUnidad() == null || dto.getUnidad().isEmpty())
            addError("unidad", String.format(REQUIRED_MESSAGE, "unidad"));

        return this;
    }
}
