package md.grand.medica.controller;

import md.grand.medica.entity.Patient;
import md.grand.medica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = service.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient";
    }

    @PostMapping("/add")
    public String addPatient(Patient patient) {
        service.save(patient);
        return "redirect:/patients";
    }
}