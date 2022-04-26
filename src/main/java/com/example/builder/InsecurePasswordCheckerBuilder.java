package com.example.builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.checker.InsecurePasswordChecker;
import com.example.checker.validators.LengthPasswordValidator;
import com.example.checker.validators.ValidatorType;
import com.example.checker.validators.builder.WeakListPasswordValidatorBuilder;
import com.example.checker.validators.contracts.PasswordValidator;
import com.example.checker.validators.regex.LowercasePasswordValidator;
import com.example.checker.validators.regex.NumberPasswordValidator;
import com.example.checker.validators.regex.UppercasePasswordValidator;

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


