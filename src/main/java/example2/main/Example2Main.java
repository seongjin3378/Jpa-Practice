package example2.main;

import example1.dto.Member;
import example2.dto.Content;
import example2.dto.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Example2Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {



            Post post = new Post();
            post.setPostCategory("질문 게시판");
            post.setAuthor("장아무개");
            post.setTitle("싱글톤 빈, 프로토 타입빈 차이점");
            post.setThumbnailUrl("http://localhost:8080/thumbnail/q/0");

            em.persist(post);

            Post found = em.find(Post.class, 1L);

            System.out.println(found);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
