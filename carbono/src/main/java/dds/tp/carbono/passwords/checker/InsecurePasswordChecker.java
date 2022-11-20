package dds.tp.carbono.passwords.checker;

import java.util.Set;

import dds.tp.carbono.passwords.checker.validators.contracts.PasswordValidator;



public class InsecurePasswordChecker {

    private Set<PasswordValidator> validators;

    public InsecurePasswordChecker(Set<PasswordValidator> validators) {
        this.validators = validators;
    }

    public boolean isSecure(String password) {
        return this.validators.stream().allMatch(validator -> validator.validate(password));
    }
}