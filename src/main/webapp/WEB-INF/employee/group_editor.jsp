<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 07.06.2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${group.getName()}"/></title>
</head>
<body>
<%@ include file="../finder.jspf"%>
<%@ include file="../navbar.jspf"%>
<div class="title"><c:out value="${student.getName()}"/> </div>
    <form action="/employee/update/group/perform_update" method="post">
        <label>Name: </label>
        <input class="non_hittable" type="text" name="groupName">
        <label>Add/Delete student by name: (leave blank if isn't needed)</label>
        <input class="non_hittable" type="text" name="studentName">
        <select name="parameter" id="parameterChoice">
            <option value="add">Add</option>
            <option value="delete">Delete from group</option>
        </select>
        <input type="submit" value="Update">
        <input type="submit" value="Delete" formaction="/employee/delete/group/perform_deletion">
    </form>
<%@ include file="../footer.jspf"%>
</body>
</html>
