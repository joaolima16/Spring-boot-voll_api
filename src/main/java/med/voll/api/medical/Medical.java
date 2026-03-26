package med.voll.api.medical;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "medicals")
@Entity(name = "Medical")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    private Boolean active;

    @Embedded
    private Address address;

    public Medical(MedicalRegisterRequest medicalRecord){
        this.name = medicalRecord.name();
        this.active = true;
        this.email = medicalRecord.email();
        this.crm = medicalRecord.crm();
        this.phone = medicalRecord.phone();
        this.speciality = medicalRecord.speciality();
        this.address = new Address(medicalRecord.address());
    }
    public void update(MedicalUpdateRequest medicalUpdateRequest) {
        if(medicalUpdateRequest.name() != null){
            this.name = medicalUpdateRequest.name();
        }
        if(medicalUpdateRequest.phone() != null){
            this.phone = medicalUpdateRequest.phone();
        }
        if(medicalUpdateRequest.address() != null){
            this.address.update(medicalUpdateRequest.address());
        }
    }
    public void delete() {
        this.active = false;
    }
}
