package dds.tp.carbono.http.validator;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public abstract class ValidateResult {
    
    @Getter private boolean valid = true;
    @Getter private Map<String, String> errors;

    protected void addError(String field, String message) {
        if (errors == null) {
            this.valid = false;
            this.errors = new HashMap<>();
        }

        errors.put(field, message);
    }
}
