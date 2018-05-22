<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2018-04-27
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" action="login" method="post">
    <p>
        E-mail:<br>
        <input type="text" name="username">
    </p>
    <p>
        Password:<br>
        <input type="password" name="password"/>
    </p>
    <input type="submit" name="submit" value="sign in"/>
</form>
TODO: dodać możliwość logowania się za pomocą id użytkownika<br><br>
</body>
</html>
