package example1_practice.main;


import example1.dto.Member;
import example1_practice.dto.Appointment;
import example1_practice.dto.Hospital;
import example1_practice.dto.MemberTwo;
import example1_practice.dto.Patient;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class PracticeMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Hospital hospital = new Hospital();
            hospital.setName("아무개 병원");
            em.persist(hospital);

            MemberTwo member = new MemberTwo();
            member.setName("김아무개");
            em.persist(member); // 영속성 상태

            MemberTwo member2 = new MemberTwo();
            member2.setName("이아무개");
            em.persist(member2);


            //member.getHospital().getMembers() 불러올수 있을지 유무
            member.setHospital(hospital); //1차 캐시에서는 조회 못함, 준영속 시 가능 (연관관계 설정됨)
            hospital.addMember(member2); // 1차캐시에서는 조회가능, 준영속 시 안들어감 DB에서 못불러옴 (연관관계 설정 안됨)



            MemberTwo found = em.find(MemberTwo.class, 1L);
            List<MemberTwo> founds = found.getHospital().getMembers();

            for(MemberTwo m : founds) {
                //member2만 조회 가능
                System.out.println("======= 1차캐시에서 불러올 경우 =======");
                System.out.println(m.getName() +" 1차 캐시 조회 가능");
            }



            em.flush();
            em.clear();
            //영속성 컨텍스트 초기화 후 DB에서 조회
            found = em.find(MemberTwo.class, 1L);
            founds = found.getHospital().getMembers();

            for(MemberTwo m : founds) {
                System.out.println("====== 1차캐시 초기화 후 DB에서 불러옴 ======");
                System.out.println(m.getName() +" ");
            }


            Patient patient = new Patient();
            patient.setAge(23);
            patient.setName("박아무개");
            em.persist(patient);



            Appointment appointment = new Appointment();
            appointment.setAppointmentTime(LocalDateTime.now());

            patient.addAppointment(appointment);
            em.persist(appointment);

            Appointment appointment2 = new Appointment();
            appointment2.setAppointmentTime(LocalDateTime.now().plusDays(2));
            appointment2.changePatient(patient);
            em.persist(appointment2);




            em.flush();
            em.clear();











            Appointment found2 = em.find(Appointment.class, 1L);
            List<Appointment> founds2 = found2.getPatient().getAppointments();

            for(Appointment a : founds2) {
                System.out.println("====== 1차캐시 초기화 & DB에서 불러와도 모두 조회됨 ======");
                System.out.println("이름: "+a.getPatient().getName() +", 나이: " + a.getPatient().getAge() + ", 등록 일: "+ a.getAppointmentTime());
            }







            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }


}
