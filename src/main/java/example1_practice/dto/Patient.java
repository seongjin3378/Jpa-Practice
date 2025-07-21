package example1_practice.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//id, age, name,

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    private int age;
    private String name;


    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<Appointment>();


    public void addAppointment(Appointment appointment) {

        this.appointments.add(appointment);
        appointment.setPatient(this);



    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointment(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public PatientDetail getPatientDetail() {
        return patientDetail;
    }

    public void setPatientDetail(PatientDetail patientDetail) {
        this.patientDetail = patientDetail;
    }

    @OneToOne()
    @JoinColumn(name = "patient_detail_id") //fk
    private PatientDetail patientDetail;
}
