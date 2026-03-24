package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medical.Medical;
import med.voll.api.medical.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
