<html>
<head>
    <title>Registration Application</title>
</head>

<%--<form action="authentification" method="post">--%>
<form action="/login" method="post">
    <%--Login:<input type="text" name="name"><br>--%>
    Login:<input type="text" name="j_username"><br>

    <%--Password:<input type="password" name="password"><br>--%>
    Password:<input type="password" name="j_password"><br>
    <input type="submit" value="Submit">
</form>



<body>

<h2>If you do not have an account</h2>
<form action="registration" method="get">
    <input type="submit" value="Registration">
</form>

</body>
</html>

