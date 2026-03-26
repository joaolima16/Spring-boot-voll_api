package med.voll.api.medical;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record MedicalUpdateRequest (
        @NotNull
        Long id,
        String name,
        String phone,
        DataAddress address){
}
