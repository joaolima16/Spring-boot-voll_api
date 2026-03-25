package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PatientRecord;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public void create(@Valid @RequestBody PatientRecord patientRecord){
            this.patientRepository.save(new Patient(patientRecord));
    }
    @GetMapping
    public Page<PatientResponse> listen(Pageable pageable){
      return this.patientRepository.findAll(pageable).map(PatientResponse::new);

    }
}
