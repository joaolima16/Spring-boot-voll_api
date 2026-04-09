package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medical.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medical")
public class MedicalController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@Valid  @RequestBody MedicalRegisterRequest medicalRecord, UriComponentsBuilder uriBuilder){
        var medical = new Medical(medicalRecord);
        medicalRepository.save(new Medical(medicalRecord));
        var uri = uriBuilder.path("/medical/{id}").buildAndExpand(medical.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicalResponse(medical));
    }
    @GetMapping("/{id}")
    public ResponseEntity detailsMedical(@PathVariable Long id){
        var medical = medicalRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicalResponse(medical));

    }
    @GetMapping
    public ResponseEntity<Page<MedicalResponse>> listen(Pageable pagination){
        var pages = medicalRepository.findAllByActiveTrue(pagination).map(MedicalResponse::new);
        return ResponseEntity.ok(pages);
    }

    @Transactional
    @PutMapping()
    public ResponseEntity<MedicalResponseUpdate> update(@RequestBody @Valid MedicalUpdateRequest medicalUpdateRequest){
        var medical = medicalRepository.getReferenceById(medicalUpdateRequest.id());
        medical.update(medicalUpdateRequest);
        var medicalResponse = new MedicalResponseUpdate(medical);
        return ResponseEntity.ok(medicalResponse);
    }
    @Transactional
    @DeleteMapping("/{id}")
     public ResponseEntity delete(@PathVariable Long id){
       var medical = medicalRepository.getReferenceById(id);
        medical.delete();
        return ResponseEntity.noContent().build();
    }
}
