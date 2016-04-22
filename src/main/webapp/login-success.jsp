<%@ page import="org.springframework.context.support.AbstractApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="model.User" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>


<style>

    p    {color: lawngreen;
        border: 3px solid grey;
        font-size: 200%;}


</style>

<p>You have ADMINISTRATOR rights!</p>
<%
//    LoginBean bean=(LoginBean)request.getAttribute("bean");
//    out.print("Welcome, "+bean.getName());

//    AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    WebApplicationContext cont = WebApplicationContextUtils.getWebApplicationContext(application);
    UserDAO dao = (UserDAO) cont.getBean("userDAO");



    for(User u: dao.findAllUsers()){
        out.print("<tr><td>" + u.getFirstName()+" "+ u.getMobile() + "</td>\n");
    }


%>
