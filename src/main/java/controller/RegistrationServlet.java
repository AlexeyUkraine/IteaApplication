package controller;

/**
 * Created by alexey.savchuk on 22.04.2016.
 */
import dao.UserDAO;
import model.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        String login=request.getParameter("login");
        String password=request.getParameter("password");

        String status;


//        LoginBean bean=new LoginBean();
//        bean.setName(name);
//        bean.setPassword(password);
//        request.setAttribute("bean",bean);
//
//        boolean status=bean.validate();



        if(login.equals("alexey")&&password.equals("admin")){
            //should

//            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//            UserDAO dao = (UserDAO) context.getBean("userDAO");
//
//            List<User> item= dao.findAllUsers();
//            request.setAttribute("users", item);

            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsps/admin-page.jsp");
            rd.forward(request, response);

        }
        else if(login.equals("adm")&&password.equals("admin")){
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsps/loginUser.jsp");
            rd.forward(request, response);
        }

        else {
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsps/login-error.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
