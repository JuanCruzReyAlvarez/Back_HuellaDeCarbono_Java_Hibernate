package dds.tp.carbono.builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dds.tp.carbono.checker.InsecurePasswordChecker;
import dds.tp.carbono.checker.validators.LengthPasswordValidator;
import dds.tp.carbono.checker.validators.ValidatorType;
import dds.tp.carbono.checker.validators.builder.WeakListPasswordValidatorBuilder;
import dds.tp.carbono.checker.validators.contracts.PasswordValidator;
import dds.tp.carbono.checker.validators.regex.LowercasePasswordValidator;
import dds.tp.carbono.checker.validators.regex.NumberPasswordValidator;
import dds.tp.carbono.checker.validators.regex.UppercasePasswordValidator;

public class InsecurePasswordCheckerBuilder {

    //singleton
    private static InsecurePasswordCheckerBuilder instance;

    public static InsecurePasswordCheckerBuilder getInstance() {
        if (instance == null)
            instance = new InsecurePasswordCheckerBuilder();

        return instance;
    }

    //strategy
    private Map<ValidatorType, PasswordValidator> validators;
    
    private InsecurePasswordCheckerBuilder() {
        this.validators = new HashMap<ValidatorType, PasswordValidator>();

        validators.put(ValidatorType.LENGTH, new LengthPasswordValidator());
        validators.put(ValidatorType.LOWERCASE, new LowercasePasswordValidator());
        validators.put(ValidatorType.UPPERCASE, new UppercasePasswordValidator());
        validators.put(ValidatorType.NUMERIC, new NumberPasswordValidator());
        validators.put(ValidatorType.WEAKLIST, WeakListPasswordValidatorBuilder.build());
    }

    public InsecurePasswordChecker buildPasswordChecker() {
        return this.buildPasswordChecker(Arrays.asList(ValidatorType.values()));
    }
    
    public InsecurePasswordChecker buildPasswordChecker(ValidatorType validator) {
        return this.buildPasswordChecker(Arrays.asList(validator));
    }

    public InsecurePasswordChecker buildPasswordChecker(List<ValidatorType> types) {
        return new InsecurePasswordChecker(types.stream().
            map(type -> this.validators.get(type))
            .collect(Collectors.toSet()));
    }
}


