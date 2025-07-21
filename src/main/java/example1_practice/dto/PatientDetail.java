package example1_practice.dto;

import javax.persistence.*;

@Entity
public class PatientDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientDetailId;

    private String address;

    private String guardName;


    @OneToOne(mappedBy = "patientDetail")
    private Patient patient;

}
