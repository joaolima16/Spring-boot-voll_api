package med.voll.api.domain.medical;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.DataAddress;

public record MedicalUpdateRequest (
        @NotNull
        Long id,
        String name,
        String phone,
        DataAddress address){
}
