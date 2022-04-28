package dds.tp.carbono.checker.validators.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dds.tp.carbono.checker.validators.contracts.PasswordValidator;

//template method
public abstract class RegexValidator implements PasswordValidator{
    
    @Override
    public boolean validate(String password) {
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }

    protected abstract String getRegex();
}
