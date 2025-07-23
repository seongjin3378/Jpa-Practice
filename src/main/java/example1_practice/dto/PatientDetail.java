package example1_practice.dto;

import javax.persistence.*;

@Entity
public class PatientDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientDetailId;

    private String address;

    private String guardName;


    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
