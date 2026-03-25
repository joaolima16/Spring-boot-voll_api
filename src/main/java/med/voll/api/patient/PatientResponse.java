package med.voll.api.patient;

import med.voll.api.address.Address;

public record PatientResponse(String name, String email, String phone, String cpf, Address address) {
    public PatientResponse(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAddress());
    }
}
