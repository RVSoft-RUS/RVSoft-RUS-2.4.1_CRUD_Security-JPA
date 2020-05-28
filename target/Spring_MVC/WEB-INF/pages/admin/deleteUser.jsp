<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div align="center">
    <h2>Users Management - Delete user</h2>
</div>

<form action="${pageContext.request.contextPath}/admin/delete" method="post">
    <table border="0" cellpadding="5">
        <%--        <jsp:useBean id="userForEdit" scope="request"/>--%>
        <tr>
            <td><label>ID:</label></td>
            <td><input type="text" name="id" value="<c:out value='${userForDelete.id}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Name:</label></td>
            <td><input type="text" name="name" value="<c:out value='${userForDelete.name}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><input type="text" name="surname" value="<c:out value='${userForDelete.surname}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Age:</label></td>
            <td><input type="text" name="age" value="<c:out value='${userForDelete.age}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login" value="<c:out value='${userForDelete.login}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="text" name="password" value="<c:out value='${userForDelete.password}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Role:</label></td>
            <td><input type="radio" name="role" value="user" ${userForDelete.role.equals("user")?'checked="checked"':''}>
                user<br/>
                <input type="radio" name="role" value="admin" ${userForDelete.role.equals("admin")?'checked="checked"':''}
                       аdmin</td>
        </tr>
        <tr>
            <td>A you sure?</td>
            <td>
                <button type="submit"> DELETE </button>
            </td>
        </tr>
    </table>
</form>
<div>
    <button onclick="location.href='/admin/users'"> CANCEL </button>
    Click to cancel and return to see all users/
</div>
<br>
<br>
</body>
</html>