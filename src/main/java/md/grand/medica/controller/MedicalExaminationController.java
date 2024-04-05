package md.grand.medica.controller;

import md.grand.medica.entity.MedicalExamination;
import md.grand.medica.entity.Patient;
import md.grand.medica.service.MedicalExaminationService;
import md.grand.medica.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/examinations")
public class MedicalExaminationController {
    @Autowired
    private MedicalExaminationService service;

    @Autowired
    private PatientService patientService;

    @GetMapping("{patientId}")
    public String getAll(Model model, @PathVariable Long patientId) {
        patientService.getPatientById(patientId).ifPresent(p -> model.addAttribute("patient", p));
        List<MedicalExamination> examinations = service.getMedicalExaminationByPatientId(patientId);
        model.addAttribute("examinations", examinations);
        return "examination";
    }

    @PostMapping("/add")
    public String add(MedicalExamination examination) {
        service.save(examination);
        return "redirect:/examinations/" + examination.getPatientId();
    }

}