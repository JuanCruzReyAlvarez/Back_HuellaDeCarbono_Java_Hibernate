package dds.tp.carbono.http.validator;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.http.dto.ErrorDTO;
import lombok.Getter;

public abstract class ValidateResult {
    
    @Getter private boolean valid = true;
    @Getter private List<ErrorDTO> errors;

    protected void addError(String field, String message) {
        if (errors == null) {
            this.valid = false;
            this.errors = new ArrayList<ErrorDTO>();
        }

        errors.add(new ErrorDTO(field, message));
    }
}
