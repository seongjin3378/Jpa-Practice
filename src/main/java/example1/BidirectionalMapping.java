package example1;


import example1.dto.HospitalInfo;
import example1.dto.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;





public class BidirectionalMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            HospitalInfo hospitalInfo = new HospitalInfo();
            hospitalInfo.setHospitalName("아무개 정형외과");

            em.persist(hospitalInfo);

            Member member = new Member();
            member.setName("직원 1");
            member.changeHospitalInfo(hospitalInfo);
            em.persist(member);

            Member member2 = new Member();
            member2.setName("직원 2");
            hospitalInfo.addMember(member2);


            em.persist(member2);


            //주인쪽 adminList에는 add를 하지 않았기 때문에비어있음

            em.flush(); //db 쿼리 전송
            //em.clear(); //엔티티 준영속 상태 (1차 캐시 비움)


            //em.fisuh() + em.clear()를 하면 1차캐시가 아닌 DB에서 직접 불러오기 때문에
            //adminList()가 채워진 채로 조회 가능
            HospitalInfo found = em.find(HospitalInfo.class, 1L); //준영속 상태이므로 다시 DB에서 불러옴

            //Member found = em.find(Member.class, member.getId());

            List<Member> mList= found.getAdminList();
            //List<Member> mList = found.getHospitalInfo().getAdminList();

            System.out.println(mList);
            for(Member m : mList) {
                System.out.println("관리자 이름: "+m.getName());
            }

            tx.commit(); //1차 캐시를 기준으로 커밋함

        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }
}
