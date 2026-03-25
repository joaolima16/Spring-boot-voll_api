package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medical.Medical;
import med.voll.api.medical.MedicalRecord;
import med.voll.api.medical.MedicalRepository;
import med.voll.api.medical.MedicalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical")
public class MedicalController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public void register(@Valid  @RequestBody MedicalRecord medicalRecord){
        medicalRepository.save(new Medical(medicalRecord));
    }
    @GetMapping
    public Page<MedicalResponse> listen(Pageable pagination){
        return medicalRepository.findAll(pagination).map(MedicalResponse::new);
    }
}
