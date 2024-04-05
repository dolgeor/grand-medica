package md.grand.medica.repository;

import md.grand.medica.entity.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {
    List<MedicalExamination> findAllByPatientId(Long patientId);
}
