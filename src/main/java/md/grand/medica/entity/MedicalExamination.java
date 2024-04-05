package md.grand.medica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MedicalExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long patientId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    private String  complaint;

    private String pathologicalAntecedentsAndCurrentTreatment;

    private String heredocollateralAnamnesis;

    private String diagnosis;

    private String recommendation;
 }