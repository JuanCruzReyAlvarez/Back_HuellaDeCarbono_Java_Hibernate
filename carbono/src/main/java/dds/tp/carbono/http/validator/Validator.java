package dds.tp.carbono.http.validator;

public abstract class Validator<T> extends ValidateResult {
    public abstract ValidateResult validate(T dto);
}
