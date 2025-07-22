package example2.main;

import example1.dto.HospitalInfo;
import example1.dto.Member;
import example2.dto.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example2ProxyMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {



            HospitalInfo hospitalInfo = new HospitalInfo();
            hospitalInfo.setHospitalName("아무개 병원");
            em.persist(hospitalInfo);

            em.flush();
            em.clear();
            //HospitalInfo found = em.find(HospitalInfo.class, hospitalInfo.getHospitalId()); // 연관관계만 설정하려고하는데 SELECT 쿼리가 실행됨
            System.out.println("=====================================================");
            HospitalInfo found = em.getReference(HospitalInfo.class, hospitalInfo.getHospitalId()); //프록시기 때문에 객체만 반환
            
            //found.getHospitalName() 호출시 SELECT 쿼리 호출 됨
            
            Member member = new Member();
            member.setName("임아무개");
            member.setHospitalInfo(found);
            em.persist(member);





            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
