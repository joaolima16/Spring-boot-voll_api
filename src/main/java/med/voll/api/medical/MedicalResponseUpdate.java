package med.voll.api.medical;

import med.voll.api.address.Address;

public record MedicalResponseUpdate(Long id, String name, String email, String crm, Speciality speciality, Address address) {
    public MedicalResponseUpdate(Medical medical){
        this(medical.getId(), medical.getName(),medical.getEmail(), medical.getCrm(),medical.getSpeciality(),medical.getAddress());
    }
}
