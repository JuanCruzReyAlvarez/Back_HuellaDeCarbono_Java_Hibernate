package dds.tp.carbono.passwords.checker.validators;

import java.util.Set;

import dds.tp.carbono.passwords.checker.validators.contracts.PasswordValidator;
import lombok.Getter;
import lombok.Setter;

public class WeakListPasswordValidator implements PasswordValidator {

    @Getter @Setter private Set<String> insecurePasswords;

    public WeakListPasswordValidator(Set<String> insecurePasswords) {
        this.insecurePasswords = insecurePasswords;
    }
    
    @Override
    public boolean validate(String password) {
        return !this.insecurePasswords.contains(password);
    }    
}
