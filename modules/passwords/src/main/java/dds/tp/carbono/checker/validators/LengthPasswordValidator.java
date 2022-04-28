package dds.tp.carbono.checker.validators;

import dds.tp.carbono.checker.validators.contracts.PasswordValidator;

public class LengthPasswordValidator implements PasswordValidator {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    @Override
    public boolean validate(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }
}
