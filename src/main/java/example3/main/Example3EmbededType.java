package example3.main;

import example1.dto.Member;
import example3.dto.Address;
import example3.dto.Company;
import example3.dto.ContactInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Example3EmbededType {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


            Member member = new Member();
            member.setName("아무개");
            member.setAddress("군산");
            member.setGender("남성");

            
            Member member2 = new Member();
            member2.setName("아무개2");
            member2.setAddress("군산");
            member2.setGender("여성");


            Member member3 = new Member();
            member3.setName("아무개3");
            member3.setGender("남성");
            member3.setAddress("전주");


            Member member4 = new Member();
            member4.setName("아무개4");
            member4.setGender("여성");
            member4.setAddress("용인");



            Company company = new Company();
            company.setAddress(new Address("아무개시 아무개 구", "305172"));
            company.addMember(member);
            company.addMember(member2);
            company.addMember(member3);
            company.addMember(member4);

            company.setContactInfo(new ContactInfo("02-2715-3020", "Company@naver.com", "232-14-2323"));
            
            company.setCompanyIndustry("반도체, 커패시터 전지, 자율주행, IT");

            em.persist(company);

            em.flush();
            em.clear();


            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();


    }
}
