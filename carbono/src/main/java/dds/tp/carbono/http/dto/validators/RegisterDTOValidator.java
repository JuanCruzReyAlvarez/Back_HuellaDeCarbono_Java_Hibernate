package dds.tp.carbono.http.dto.validators;

import dds.tp.carbono.http.dto.auth.RegisterDTO;
import dds.tp.carbono.http.validator.ValidateResult;
import dds.tp.carbono.http.validator.Validator;

public class RegisterDTOValidator extends Validator<RegisterDTO> {
    private static final String PASSWORD_FIELD_NAME = "password";
    private static final String USERNAME_FIELD_NAME = "username";
    private static final String ROL_FIELD_NAME = "rol";
    private static final String REQUIRED_MESSAGE = "The %s field is required";

    @Override
    public ValidateResult validate(RegisterDTO dto) {
        
        if (dto.getPassword() == null || dto.getPassword().isEmpty())
            addError(PASSWORD_FIELD_NAME, String.format(REQUIRED_MESSAGE, PASSWORD_FIELD_NAME));
        
        if (dto.getUsername() == null || dto.getUsername().isEmpty())
            addError(USERNAME_FIELD_NAME, String.format(REQUIRED_MESSAGE, USERNAME_FIELD_NAME));

        if (dto.getRol() == null || dto.getRol().isEmpty())
            addError(ROL_FIELD_NAME, String.format(REQUIRED_MESSAGE, ROL_FIELD_NAME));

        return this;
    }
}