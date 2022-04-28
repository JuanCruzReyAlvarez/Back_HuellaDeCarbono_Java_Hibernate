package dds.tp.carbono.checker.validators.regex;

public class NumberPasswordValidator extends RegexValidator {

    private static final String VALIDATION_REGEXP = "(?=.*\\d)";

    @Override
    protected String getRegex() {
        return VALIDATION_REGEXP;
    }
}
