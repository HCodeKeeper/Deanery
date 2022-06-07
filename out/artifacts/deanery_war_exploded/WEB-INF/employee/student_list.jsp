<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 07.06.2022
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All students</title>
</head>
<body>
<%@include file="../finder.jspf"%>
<%@include file="../navbar.jspf"%>
    <table>
        <div>Students in database</div>
        <tr>
            <td>Id</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td><c:out value="${student.getId().toString()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
            </tr>
        </c:forEach>
    </table>
    <form action="/employee/update/student">
        <label>Edit student: </label>
        <label>Name</label>
        <input class="non_hittable" type="text" name="studentName"/>
        <input type="submit" value="Edit">
    </form>
<%@include file="../footer.jspf"%>
</body>
</html>
