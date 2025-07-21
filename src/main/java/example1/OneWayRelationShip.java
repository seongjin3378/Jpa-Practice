package example1;

import example1.dto.BankInfo;
import example1.dto.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//단방향 연관관계
public class OneWayRelationShip {
    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

/*            // 1) BankInfo 생성 및 저장
            BankInfo bank = new BankInfo();
            bank.setBankId(1L);
            bank.setBankName("우리은행");
            bank.setAccountNumber("123-456-789");
            em.persist(bank);

            // 2) Member 생성 → bankInfo 연관 설정 후 저장
            Member member = new Member();
            member.setId(3L);
            member.setUserName("goodJob");
            member.setBankInfo(bank);
            em.persist(member);*/


            // BankInfo 생성 및 영속성 저장
            BankInfo bank = new BankInfo();
            bank.setBankName("우리은행");
            bank.setAccountNumber("123-456-789");
            em.persist(bank);

            // Member 생성 -> bankInfo 연관 설정 후 저장
            Member member = new Member();
            member.setName("goodJob");
            member.setBankInfo(bank);
            em.persist(member);

            bank.setMember(member);





            tx.commit(); //자동으로 flush() 호출

            BankInfo found = em.find(BankInfo.class, 1L);
            System.out.println(found.getMember().getName());
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }
}
