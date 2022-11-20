package dds.tp.carbono.passwords.checker.validators.regex;

public class LowercasePasswordValidator extends RegexValidator {

    private static final String VALIDATION_REGEXP = "(?=.*[a-z])";

    @Override
    protected String getRegex() {
        return VALIDATION_REGEXP;
    }
}
