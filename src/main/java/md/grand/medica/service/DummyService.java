package md.grand.medica.service;

import jakarta.annotation.PostConstruct;
import md.grand.medica.entity.*;
import md.grand.medica.repository.MedicalExaminationRepository;
import md.grand.medica.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DummyService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MedicalExaminationRepository medicalExaminationRepository;

    @PostConstruct
    public void addData() {

        // Creating Patient objects using builder pattern
        Patient patient1 = patientRepository.save(Patient.builder().firstName("John").lastName("Doe").phone("123-456-7890").location("New York").birthDate(Date.valueOf("1990-01-01")).build());

        Patient patient2 = patientRepository.save(Patient.builder().firstName("Jane").lastName("Smith").phone("987-654-3210").location("Los Angeles").birthDate(Date.valueOf("1985-05-15")).build());

        Patient patient3 = patientRepository.save(Patient.builder().firstName("Emily").lastName("Johnson").phone("111-222-3333").location("Chicago").birthDate(Date.valueOf("1988-08-20")).build());

        Patient patient4 = patientRepository.save(Patient.builder().firstName("Michael").lastName("Brown").phone("444-555-6666").location("Houston").birthDate(Date.valueOf("1975-03-12")).build());

        // Creating MedicalExamination objects using builder pattern
        medicalExaminationRepository.save(MedicalExamination.builder().date(Date.valueOf("2023-01-10")).complaint("Headache").pathologicalAntecedentsAndCurrentTreatment("None").heredocollateralAnamnesis("Family history of diabetes").diagnosis("Migraine").recommendation("Prescribed painkillers").patientId(patient1.getId()) // Associate with patient1
                .build());

        medicalExaminationRepository.save(MedicalExamination.builder().date(Date.valueOf("2023-02-05")).complaint("Cough and fever").pathologicalAntecedentsAndCurrentTreatment("None").heredocollateralAnamnesis("None").diagnosis("Common cold").recommendation("Bed rest and plenty of fluids").patientId(patient1.getId()) // Associate with patient1
                .build());

        medicalExaminationRepository.save(MedicalExamination.builder().date(Date.valueOf("2023-03-20")).complaint("Back pain").pathologicalAntecedentsAndCurrentTreatment("Chronic back pain, taking NSAIDs").heredocollateralAnamnesis("None").diagnosis("Muscle strain").recommendation("Physical therapy recommended").patientId(patient2.getId()) // Associate with patient2
                .build());

        medicalExaminationRepository.save(MedicalExamination.builder().date(Date.valueOf("2023-04-15")).complaint("Fatigue").pathologicalAntecedentsAndCurrentTreatment("None").heredocollateralAnamnesis("Family history of thyroid disorder").diagnosis("Hypothyroidism").recommendation("Thyroid hormone replacement therapy").patientId(patient3.getId()) // Associate with patient3
                .build());

        medicalExaminationRepository.save(MedicalExamination.builder().date(Date.valueOf("2023-05-10")).complaint("Abdominal pain").pathologicalAntecedentsAndCurrentTreatment("GERD").heredocollateralAnamnesis("None").diagnosis("Gastritis").recommendation("Antacids and dietary changes recommended").patientId(patient4.getId()) // Associate with patient4
                .build());

        System.out.println("Inserted Dummy data");
        System.out.println("=============================================================");
        patientRepository.findAll().forEach(System.out::println);
        System.out.println("=============================================================");
        medicalExaminationRepository.findAll().forEach(System.out::println);
        System.out.println("=============================================================");
    }
}
 