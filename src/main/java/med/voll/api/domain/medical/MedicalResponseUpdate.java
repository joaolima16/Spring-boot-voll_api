package med.voll.api.domain.medical;

import med.voll.api.domain.address.Address;

public record MedicalResponseUpdate(Long id, String name, String email, String crm, Speciality speciality, Address address) {
    public MedicalResponseUpdate(Medical medical){
        this(medical.getId(), medical.getName(),medical.getEmail(), medical.getCrm(),medical.getSpeciality(),medical.getAddress());
    }
}
