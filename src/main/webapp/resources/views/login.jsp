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
<form:form action="login" modelAttribute="newUser" method="post">
    TODO: dodać możliwość logowania się za pomocą id użytkownika<br><br>
    E-mail:<br>
    <form:input path="email"/><br><br>
    Password:<br>
    <form:password path="password"/><br><br>
    <input type="submit" value="sign in">
</form:form>
</body>
</html>
