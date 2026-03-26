package med.voll.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Entity(name = "Patient")
@Table(name = "patient")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private String phone;
    private String cpf;
    @Embedded
    private Address address;

    public Patient(PatientRecord patientRecord){
        this.name = patientRecord.name();
        this.active = true;
        this.email = patientRecord.email();
        this.phone = patientRecord.phone();
        this.cpf = patientRecord.cpf();
        this.address = new Address(patientRecord.address());
    }
    public void update(PatientUpdateRequest patientUpdateRequest) {
        if(patientUpdateRequest.name() != null){
            this.name = patientUpdateRequest.name();
        }
        if(patientUpdateRequest.phone() != null){
            this.phone = patientUpdateRequest.phone();
        }
        if(patientUpdateRequest.address() != null){
            this.address.update(patientUpdateRequest.address());
        }
    }
    public void delete(){
        this.active = false;
    }
}
