<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2018-04-11
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
Strona34566
<ul>
    <c:forEach items="${threads}" var="thread" varStatus="threadLoop">
        <li>
            ${thread.name}
        </li>
    </c:forEach>
</ul>

</body>
</html>
