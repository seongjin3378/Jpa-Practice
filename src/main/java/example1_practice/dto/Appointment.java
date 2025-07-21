package example1_practice.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private LocalDateTime appointmentTime;

/*    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberTwo member;*/

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

/*    public MemberTwo getMember() {
        return member;
    }

    public void setMember(MemberTwo member) {
        this.member = member;

    }*/

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;

    }

    public void changePatient(Patient patient) {
        this.patient = patient;
        patient.addAppointment(this);

    }
}
