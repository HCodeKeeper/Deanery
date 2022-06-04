<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Please Log In</title>
</head>
<body>
    <h1>Please Log In</h1>
    <div><c:if test="${requestScope.badCredits eq true}"> Invalid username and password.</c:if></div>

    <div><c:if test="${requestScope.loggedOut eq true}">You have been logged out.</c:if></div>
    <form action="/login/perform_login" method="post">
        <div>
            <label for="userType">As </label>
            <select name="types" id="userType">
                <option value="student">Student</option>
                <option value="employee">Deanery Employee</option>
            </select>
        </div>
        <div>
            <input type="text" name="username" placeholder="Username"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
        <input type="submit" value="Log in" />
    </form>
</body>
</html>