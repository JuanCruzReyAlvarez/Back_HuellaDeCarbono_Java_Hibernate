package dds.tp.carbono.passwords.checker.validators.regex;

public class UppercasePasswordValidator extends RegexValidator {

    private static final String VALIDATION_REGEXP = "(?=.*[A-Z])";

    @Override
    protected String getRegex() {
        return VALIDATION_REGEXP;
    }
}