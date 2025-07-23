package example2.main;

import example1_practice.dto.Patient;
import example1_practice.dto.PatientDetail;
import example2.dto.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example2OrPhanObject {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Patient patient = new Patient();
            patient.setName("홍길동");
            patient.setAge(140);

            PatientDetail patientDetail = new PatientDetail();
            patientDetail.setAddress("아무개 시 아무개 동 11-3 ");
            patientDetail.setGuardName("OneToOne 헷갈림");

            patient.setPatientDetail(patientDetail);

            //OneToOne 이나 OneToMany 처럼 개인 소유일때만 써야한다
            em.persist(patient);
            em.flush();

            em.remove(patient);







            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
