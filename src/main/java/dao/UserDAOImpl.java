package dao;

import hibernate.HiberUtil;
import model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository(value= "userDAO")
public class UserDAOImpl implements UserDAO {

    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public long saveUser(User user) {
//        Session session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        long id = (Long) session.save(user);
//        session.getTransaction().commit();
//        System.out.println("User saved");
//        return id;
        em.persist(user);
        em.flush();
        return  user.getId();

    }

    @Transactional
    public void deleteUserById(long user_id) {
//        Session session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        User user = (User) session.get(User.class, user_id);
//        session.delete(user);
//        session.getTransaction().commit();
        User user = em.find(User.class, user_id);
        em.remove(user);
    }


    @Transactional
    public void updateUser(long user_id, String firstName, String secondName, int mobile) {
//        Session session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        User user = (User) session.get(User.class, user_id);
//        user.setFirstName(firstName);
//        user.setSecondName(secondName);
//        user.setMobile(mobile);
//        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
//        session.getTransaction().commit();
        User user = em.find(User.class, user_id);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMobile(mobile);

    }


    @Transactional
    public List<User> findAllUsers() {
//        Session session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        @SuppressWarnings("unchecked")
//       // List<User> users = (List<User>) session.createQuery("FROM users u ORDER BY u.firstName ASC").list();
//        List<User> users = (List<User>) session.createQuery("FROM User ").list();
//        session.getTransaction().commit();
//        return users;
        Query query = em.createQuery("select c from User c");
        List<User> userList = query.getResultList();
        return userList;
    }


    @Transactional
    public User findById(long user_id) {
//        Session session = HiberUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        @SuppressWarnings("unchecked")
//        User user = (User) session.get(User.class, user_id);
//      //  session.close();
//        session.getTransaction().commit();
//        return user;
        return em.find(User.class, user_id);


    }


}
