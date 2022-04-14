package com.example.utils;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

public class InsecurePasswordChecker {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final String VALIDATION_REGEXP = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])";

    @Getter @Setter private Set<String> insecurePasswords;

    public boolean isSecure(String password) {
        return this.containsUpperLowerAndNumberChar(password) &&
                this.hasMinimumLength(password) &&
                !this.belongsToWeakPasswordsList(password);
    }

    private boolean belongsToWeakPasswordsList(String password) {
        return this.insecurePasswords.contains(password);
    }

    private boolean hasMinimumLength(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    private boolean containsUpperLowerAndNumberChar(String password) {
        Pattern pattern = Pattern.compile(VALIDATION_REGEXP);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}