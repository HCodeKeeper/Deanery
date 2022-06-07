<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 06.06.2022
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deanery-Employee</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
    <%@ include file="../navbar.jspf"%>
    <div class="container">
        <%@ include file="../finder.jspf"%>
        <h1 class="tip">Start searching for group by either its name or student's one to edit/delete</h1>
        <div class="form">
            <div><span>Find student:</span></div>
            <form action="/employee/update/student">
                <label>Name</label>
                <input class="non_hittable" type="text" name="studentName"/>
                <input type="submit" value="Find">
            </form>
        </div>

        <div class="form">
            <div><span>Create student:</span></div>
            <form action="/employee/create/student/perform_creation" method="post">
                <label>Name</label>
                <input class="non_hittable" type="text" name="studentName"/>
                <label>Login</label>
                <input class="non_hittable" type="text" name="studentLogin"/>
                <label>Password</label>
                <input class="non_hittable" type="password" name="studentPassword"/>
                <input type="submit" value="Create">
            </form>
        </div>

        <div class="form">
            <div><span>Create group:</span></div>
            <form action="/employee/create/group/perform_creation" method="post">
                <label>Name</label>
                <input class="non_hittable" type="text" name="groupName"/>
                <input type="submit" value="Create">
            </form>
        </div>
        <%@ include file="../footer.jspf"%>
    </div>
</div>
</body>
</html>
