package example3.main;

import example1.dto.Member;
import example3.dto.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ExampleElementCollection {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Customer customer = new Customer("아무개1", "익산", "IT 인강 강사", "롤");
            Customer customer2 = new Customer("아묵개2", "신림", "정보보안가 취준생", "롤");
            Customer customer3 = new Customer("아무개3", "성남", "백엔드 개발자", "롤");
            Customer customer4 = new Customer("아무개4", "용인", "ERP 풀스택 개발자", "롤");

            List<Customer> customers = new ArrayList<Customer>();
            customers.add(customer);
            customers.add(customer2);
            customers.add(customer3);
            customers.add(customer4);

            PcRoom pcRoom = new PcRoom();
            pcRoom.setCity("신림");
            pcRoom.setName("아무개 피시방");
            pcRoom.setCustomers(customers);

            em.persist(pcRoom);
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
