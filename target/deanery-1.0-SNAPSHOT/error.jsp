<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 20.05.2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Something went wrong. Try again later.</h1>
    <div><p1><c:out value="${requestScope.cause}"/></p1></div>
    <div><a href="/login">Return to login page</a></div>
</body>
</html>
