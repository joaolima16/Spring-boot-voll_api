package med.voll.api.patient;

import med.voll.api.address.DataAddress;

public record PatientUpdateRequest(Long id, String name, String phone, String email, DataAddress address) {
}
