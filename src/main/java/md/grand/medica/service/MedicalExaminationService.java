package md.grand.medica.service;

import md.grand.medica.entity.MedicalExamination;
import md.grand.medica.repository.MedicalExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalExaminationService {
    @Autowired
    private MedicalExaminationRepository repository;

    public List<MedicalExamination> getMedicalExaminationByPatientId(Long patientId) {
        return repository.findAllByPatientId(patientId);
    }

    public MedicalExamination save(MedicalExamination examination) {
        return repository.save(examination);
    }
}