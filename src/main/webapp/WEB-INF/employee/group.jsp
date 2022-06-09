<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 06.06.2022
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="Employee-${group.getName()}"/> </title>
    <link href="../../style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <%@ include file="../navbar.jspf"%>

        <div class="container">
            <%@include file="../finder.jspf"%>
    <%@ include file="../group.jspf"%>
            <div class="form">
        <form action="/employee/update/student" >

            <div><span>Edit student:</span></div>
            <label>Name</label>
            <input class="non_hittable" type="text" name="studentName"/>
            <input type="submit" value="Edit">
            <input type="submit" value="Delete from group", formaction="/employee/delete/student">
        </form>
            </div>

            <div class="form">
    <form action="/employee/update/group">
        <div><span>Edit Group: </span></div>
        <label>Name</label>
        <input class="non_hittable" type="text" name="groupName" value="${group.getName()}" readonly="readonly"/>
        <input type="submit" value="Edit">
        <input type="submit" value="Delete", formaction="/employee/delete/student">
    </form>
            </div>
    <%@ include file="../footer.jspf"%>
        </div>
</div>

</body>
</html>
