package runner;

import config.AppConfig;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Credential;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Alexey.Savchuk on 15.04.2016.
 */
//@ContextConfiguration(locations = {"/spring.xml"})
public class Run {

//    @Autowired
//    private static UserDAO dao;

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


        UserDAO dao = (UserDAO) context.getBean("userDAO");

        Credential credential = new Credential();
        credential.setLogin("adminLog");
        credential.setPassword("adminPass");


        User user = new User();
        user.setFirstName("Admin");
        user.setSecondName("Adm");
        user.setMobile(67123456);

        user.setCredential(credential);
        credential.setUser(user);

       // UserDAO dao = new UserDAOImpl();
        System.out.println("User ID =" + dao.saveUser(user));

        for (User u : dao.findAllUsers()) {
            System.out.println(u);
        }
//        dao.deleteUserById(1);
//        dao.deleteUserById(2);
//        dao.deleteUserById(3);
    }

}
