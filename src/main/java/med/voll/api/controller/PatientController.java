package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<PatientResponse> create(@Valid @RequestBody PatientRecord patientRecord){
        var patient = this.patientRepository.save(new Patient(patientRecord));
        return ResponseEntity.status(HttpStatus.CREATED).body(new PatientResponse(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientResponse>> listen(Pageable pageable){
        var list = this.patientRepository.findAllByActiveTrue(pageable).map(PatientResponse::new) ;
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> details(@PathVariable Long id){
        var patient = patientRepository.getReferenceById(id);
        return ResponseEntity.ok(new PatientResponse(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Patient> update(@Valid @RequestBody PatientUpdateRequest patientUpdateRequest){
        var patient = patientRepository.getReferenceById(patientUpdateRequest.id());
        patient.update(patientUpdateRequest);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping({"/{id}"})
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
        return ResponseEntity.noContent().build();
    }
}
