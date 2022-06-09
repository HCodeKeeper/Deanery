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
    <link href="../../style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <%@ include file="../navbar.jspf"%>

<div class="container">
    <%@include file="../finder.jspf"%>
    <div class="title"><c:out value="${student.getName()}"/> </div>
    <div class="form">
        <div><span>Edit name</span></div>
    <form action="/employee/update/student/perform_update" method="post">
        <div>Previous name<input type="text" readonly="readonly" value="${student.getName()}" name="prevName"></div>
        <div><input class="non_hittable" type="text" value="" name="studentName"/></div>
        <input type="submit" value="Update">
        <input type="submit" value="Delete" formaction="/employee/delete/student/perform_deletion" />
    </form>
    </div>
<%@ include file="../footer.jspf"%>
</div>
</div>
</body>
</html>
