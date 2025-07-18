package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


/*
* 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
* 엔티티 매니저는 쓰레드간에 공유 X(사용하고 버려야 한다.)
* JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
* */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setName("goodJob");
            em.persist(member); // 영속성 상태

            /*Member findMember = em.find(Member.class, 1L);
            *//*em.find로 가져온 객체는 JPA가 관리함*//*
            findMember.setName("Jack");*/
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                            .setFirstResult(0) // 0번쨰 로우부터
                            .setMaxResults(8).getResultList();

            for(Member m : result) {
                System.out.println(m.getName());
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
