package med.voll.api.domain.patient;

import med.voll.api.domain.address.DataAddress;

public record PatientUpdateRequest(Long id, String name, String phone, String email, DataAddress address) {
}
