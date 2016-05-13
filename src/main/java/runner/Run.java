package runner;

import dao.UserDAO;
import model.Credential;
import model.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alexey.Savchuk on 15.04.2016.
 */
//@ContextConfiguration(locations = {"/servlet-context.xml"})
public class Run {

//    @Autowired
//    private static UserDAO dao;

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/appServlet/servlet-context.xml");


        UserDAO dao = (UserDAO) context.getBean("userDAO");

        Credential credential = new Credential();
        credential.setLogin("some");
        credential.setPassword("some");


        User user = new User();
        user.setFirstName("Alex");
        user.setSecondName("Bur");
        user.setMobile(67123455);

        user.setCredential(credential);
        credential.setUser(user);

       // UserDAO dao = new UserDAOImpl();
        System.out.println("User ID =" + dao.saveUser(user));

        System.out.println(dao.findByCred("Alex","Alex"));

//        dao.deleteUserById(1);
//        dao.deleteUserById(2);
//        dao.deleteUserById(3);
    }

}
