package med.voll.api.domain.medical;

import med.voll.api.domain.address.Address;

public record MedicalResponse(Long id, String name, String email, String crm, Boolean active, Speciality speciality, Address address) {
    public MedicalResponse(Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(),medical.getCrm(),medical.getActive(),medical.getSpeciality(), medical.getAddress());
    }
}
