package example2.main;

import example1_practice.dto.Appointment;
import example1_practice.dto.Patient;
import example2.dto.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Example2CascadeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


            Appointment appointment = new Appointment();
            appointment.setAppointmentTime(LocalDateTime.now());

            Appointment appointment2 = new Appointment();
            appointment2.setAppointmentTime(LocalDateTime.now());


            Patient patient = new Patient();
            patient.setName("이아무개");
            patient.setAge(29);
            patient.addAppointment(appointment);
            patient.addAppointment(appointment2);

            em.persist(patient);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
