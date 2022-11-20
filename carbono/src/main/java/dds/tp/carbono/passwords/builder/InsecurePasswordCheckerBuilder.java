package dds.tp.carbono.passwords.builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import dds.tp.carbono.passwords.checker.InsecurePasswordChecker;
import dds.tp.carbono.passwords.checker.validators.LengthPasswordValidator;
import dds.tp.carbono.passwords.checker.validators.ValidatorType;
import dds.tp.carbono.passwords.checker.validators.contracts.PasswordValidator;
import dds.tp.carbono.passwords.checker.validators.regex.LowercasePasswordValidator;
import dds.tp.carbono.passwords.checker.validators.regex.NumberPasswordValidator;
import dds.tp.carbono.passwords.checker.validators.regex.UppercasePasswordValidator;
import dds.tp.carbono.passwords.contracts.IInsecurePasswordCheckerBuilder;



public class InsecurePasswordCheckerBuilder implements IInsecurePasswordCheckerBuilder {

    //strategy
    private Map<ValidatorType, PasswordValidator> validators;
    
    public InsecurePasswordCheckerBuilder() {
        this.validators = new HashMap<ValidatorType, PasswordValidator>();

        validators.put(ValidatorType.LENGTH, new LengthPasswordValidator());
        validators.put(ValidatorType.LOWERCASE, new LowercasePasswordValidator());
        validators.put(ValidatorType.UPPERCASE, new UppercasePasswordValidator());
        validators.put(ValidatorType.NUMERIC, new NumberPasswordValidator());
    }
    
    public InsecurePasswordChecker buildPasswordChecker(ValidatorType ...types) {
        if (types.length == 0)
            types = ValidatorType.values();

        return new InsecurePasswordChecker(Arrays.stream(types).
            map(type -> this.validators.get(type))
            .collect(Collectors.toSet()));
    }
}


