package dds.tp.carbono.http.dto;

import lombok.Getter;

public class ErrorDTO {
    @Getter private String field;
    @Getter private String message;

    public ErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
}