<!doctype html public "-//w3c//dtd html 4.0 transitional//en">

<%@ page contentType="text/html; charset=windows-1251" %>
<%@ page import="java.io.*, java.text.*, dao.UserDAOImpl, model.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="org.springframework.context.support.AbstractApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>

<html>
<head>
    <title>Простейшая страница JSP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
</head>

<body>
<%

    AbstractApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/servlet-context.xml");
    UserDAO dao = (UserDAO) context.getBean("userDAO");

    for(User u: dao.findAllUsers()){
        out.print("<tr><td>" + u.getFirstName()+" "+ u.getMobile() + "</td>\n");
    }
%>
</body>
</html>




