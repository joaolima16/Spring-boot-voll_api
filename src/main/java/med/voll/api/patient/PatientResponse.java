package med.voll.api.patient;

import med.voll.api.address.Address;

public record PatientResponse(Long id, String name, String email, String phone, boolean active, String cpf, Address address) {
    public PatientResponse(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(),patient.getActive() ,patient.getCpf(), patient.getAddress());
    }
}
