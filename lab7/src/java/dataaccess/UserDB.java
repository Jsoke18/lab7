package dataaccess;

import java.util.List;
import models.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Alex Tompkins - 821984
 */

public class UserDB {

    public List<User> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    public User get(String email) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();   
       
        
        try {
            User user = em.find(User.class, email);
            
            return user;
        } finally { 
            em.close();
        }
    }

    public void insert(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        
       EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
            
            
        } catch (Exception ex) {
            trans.rollback();
            
           
        } finally {
            em.close();
        }

    }

    public void update(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        User ref = em.find(User.class, user.getEmail());

        ref.setActive(true);
        ref.setFirstName(user.getFirstName());
        ref.setLastName(user.getLastName());
        ref.setRole(user.getRole());

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(ref);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void delete(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();

        EntityManager em = emFactory.createEntityManager();

        EntityTransaction trans = em.getTransaction();

        User ref = em.find(User.class, user.getEmail());

        try {
            trans.begin();
            em.remove(ref);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }

    }
}