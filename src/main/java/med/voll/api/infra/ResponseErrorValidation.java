package med.voll.api.infra;

import org.springframework.validation.FieldError;

public record ResponseErrorValidation(String field, String message) {
    public ResponseErrorValidation(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
