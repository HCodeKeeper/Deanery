<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 07.06.2022
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${student.getName()}"/></title>
</head>
<body>
<%@include file="../finder.jspf"%>
<%@ include file="../navbar.jspf"%>
    <div class="title"><c:out value="${student.getName()}"/> </div>
    <form action="/employee/update/student/perform_update" method="post">
        <label>Edit name</label>
        <input class="non_hittable" type="text" value="" name="studentName"/>
        <input type="submit" value="Update">
        <input type="submit" value="Delete" formaction="/employee/delete/student/perform_deletion" />
    </form>
<%@ include file="../footer.jspf"%>
</body>
</html>
