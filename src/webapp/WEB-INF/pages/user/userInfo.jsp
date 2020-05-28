<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
    <table border="0" cellpadding="5">
        <tr>
            <td><label>ID:</label></td>
            <td><input type="text" name="id" value="<c:out value='${user.id}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Name:</label></td>
            <td><input type="text" name="name" value="<c:out value='${user.name}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><input type="text" name="surname" value="<c:out value='${user.surname}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Age:</label></td>
            <td><input type="text" name="age" value="<c:out value='${user.age}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login" value="<c:out value='${user.login}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="text" name="password" value="<c:out value='${user.password}' />" readonly></td>
        </tr>
         <tr>
            <td><label>Role:</label></td>
            <td><input type="text" name="role" value="<c:out value='${user.role}' />" readonly></td>
        </tr>
    </table>
</body>
</html>
