package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medical.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medical")
public class MedicalController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public void register(@Valid  @RequestBody MedicalRegisterRequest medicalRecord){
        medicalRepository.save(new Medical(medicalRecord));
    }
    @GetMapping
    public Page<MedicalResponse> listen(Pageable pagination){
        return medicalRepository.findAllByActiveTrue(pagination).map(MedicalResponse::new);
    }

    @Transactional
    @PutMapping()
    public void update(@RequestBody @Valid MedicalUpdateRequest medicalUpdateRequest){
        var medical = medicalRepository.getReferenceById(medicalUpdateRequest.id());
        medical.update(medicalUpdateRequest);
    }
    @Transactional
    @DeleteMapping("/{id}")
     public void delete(@PathVariable Long id){
       var medical = medicalRepository.getReferenceById(id);
        medical.delete();
    }
}
