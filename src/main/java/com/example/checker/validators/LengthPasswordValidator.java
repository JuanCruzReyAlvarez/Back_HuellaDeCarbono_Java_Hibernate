package com.example.checker.validators;

import com.example.checker.validators.contracts.PasswordValidator;

public class LengthPasswordValidator implements PasswordValidator {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    @Override
    public boolean validate(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }
}
