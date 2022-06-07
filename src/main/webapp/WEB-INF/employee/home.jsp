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
</head>
<body>
<%@ include file="../finder.jspf"%>
<%@ include file="../navbar.jspf"%>
<h1 class="tip">Start searching for group by either its name or student's one to edit/delete</h1>
<form action="/employee/update/student">
    <label>Find student: </label>
    <label>Name</label>
    <input class="non_hittable" type="text" name="studentName"/>
    <input type="submit" value="Find">
</form>

<form action="/employee/create/student/perform_creation" method="post">
    <label>Create student: </label>
    <label>Name</label>
    <input class="non_hittable" type="text" name="studentName"/>
    <label>Login</label>
    <input class="non_hittable" type="text" name="studentLogin"/>
    <label>Name</label>
    <input class="non_hittable" type="password" name="studentPassword"/>
    <input type="submit" value="Create">
</form>

<form action="/employee/create/group/perform_creation" method="post">
    <label>Create group: </label>
    <label>Name</label>
    <input class="non_hittable" type="text" name="groupName"/>
    <input type="submit" value="Create">
</form>
<%@ include file="../footer.jspf"%>
</body>
</html>
