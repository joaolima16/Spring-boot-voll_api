package med.voll.api.medical;

public record MedicalResponse(String name, String email, String crm, Speciality speciality) {
    public MedicalResponse(Medical medical) {
        this(medical.getName(), medical.getEmail(), medical.getCrm(), medical.getSpeciality());
    }
}
