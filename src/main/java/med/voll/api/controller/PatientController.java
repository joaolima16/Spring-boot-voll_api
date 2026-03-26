package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patient.*;
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
      return this.patientRepository.findAllByActiveTrue(pageable).map(PatientResponse::new);
    }
    @PutMapping
    @Transactional
    public void update(@Valid @RequestBody PatientUpdateRequest patientUpdateRequest){
        var patient = patientRepository.getReferenceById(patientUpdateRequest.id());
        patient.update(patientUpdateRequest);
    }
    @DeleteMapping({"/{id}"})
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
    }
}
