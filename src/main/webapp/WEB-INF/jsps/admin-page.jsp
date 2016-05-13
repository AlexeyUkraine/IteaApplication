<%@ page import="org.springframework.context.support.AbstractApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="model.User" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<html>

<body>
<style>

    p    {color: lawngreen;
        border: 3px solid grey;
        font-size: 200%;}
</style>

<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color: #150533;color: #261b33;background-color: #50a3ff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color: #07e808;color: #fefefe;background-color: #3733f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
</style>


<p>You have ADMINISTRATOR rights!</p>

<h3>Persons List</h3>
<c:if test="${!empty users}">
    <table class="tg">
        <tr>
            <th width="80">User ID</th>
            <th width="100">User First Name</th>
            <th width="100">User Second Name</th>
            <th width="100">User Mobile</th>
            <th width="100">User Login</th>
            <th width="100">User Password</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.secondName}</td>
                <td>${user.mobile}</td>
                <td>${user.credential.login}</td>
                <td>${user.credential.password}</td>
                <td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>



<h2>Return to Home</h2>
<!--redirect to root path + /start -->
<form action=<%=request.getContextPath()%>/start method="get">
    <input type="submit" value="HOME">
</form>



</body>
</html>


<%--//    AbstractApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");--%>

<%--WebApplicationContext cont = WebApplicationContextUtils.getWebApplicationContext(application);--%>



