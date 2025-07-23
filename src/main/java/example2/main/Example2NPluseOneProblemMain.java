package example2.main;

import example1.dto.HospitalInfo;
import example1.dto.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Example2NPluseOneProblemMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {



            HospitalInfo hospitalInfo = new HospitalInfo();
            hospitalInfo.setHospitalName("아무개 병원");
            em.persist(hospitalInfo);

            HospitalInfo hospitalInfo2 = new HospitalInfo();
            hospitalInfo2.setHospitalName("백아무개 병원");
            em.persist(hospitalInfo2);


            Member member = new Member();
            member.setName("임아무개");
            member.setHospitalInfo(hospitalInfo);

            em.persist(member);

            Member member2 = new Member();
            member2.setName("이아무개");
            member2.setHospitalInfo(hospitalInfo2);

            em.persist(member2);

            em.flush();
            em.clear();

            //n+1 을 해결하려면 Lazy 쓰거나 fetch join으로 한번에 가져옴
            List<Member> members = em.createQuery("select m from Member m join fetch m.hospitalInfo", Member.class).getResultList();








            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
