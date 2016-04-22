package controller;

/**
 * Created by alexey.savchuk on 22.04.2016.
 */
import java.io.IOException;
import java.io.PrintWriter;
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
            RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
            rd.forward(request, response);

        }
        else if(login.equals("adm")&&password.equals("admin")){
            RequestDispatcher rd=request.getRequestDispatcher("loginUser.jsp");
            rd.forward(request, response);
        }

        else {
            RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
