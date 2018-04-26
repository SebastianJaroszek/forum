<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2018-04-11
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form:form action="registerNewUser" method="post" modelAttribute="newUser">
    Nickname:<br>
    <form:input path="nickname"/><br><br>
    E-mail:<br>
    <form:input path="email"/><br><br>
    Password:<br>
    <form:password path="password"/><br><br>
    Confirm password:<br>
    <form:password path="confirmPassword"/><br><br>
    <input type="submit" value="sign up"/>
</form:form>
</body>
</html>
