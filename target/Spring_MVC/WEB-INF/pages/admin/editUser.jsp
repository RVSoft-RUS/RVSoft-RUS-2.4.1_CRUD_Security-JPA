<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div align="center">
    <h2>Users Management - Edit user</h2>
</div>

<form action="${pageContext.request.contextPath}/admin/edit" method="post">
    <table border="0" cellpadding="5">
        <tr>
            <td><label>ID:</label></td>
            <td><input type="text" name="id" value="<c:out value='${userForEdit.id}' />" readonly></td>
        </tr>
        <tr>
            <td><label>Name:</label></td>
            <td><input type="text" name="name" value="<c:out value='${userForEdit.name}' />"></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><input type="text" name="surname" value="<c:out value='${userForEdit.surname}' />"></td>
        </tr>
        <tr>
            <td><label>Age:</label></td>
            <td><input type="text" name="age" value="<c:out value='${userForEdit.age}' />"></td>
        </tr>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login" value="<c:out value='${userForEdit.login}' />"></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="text" name="password" value="<c:out value='${userForEdit.password}' />"></td>
        </tr>
        <tr>
            <td><label>Role:</label></td>
            <td><input type="radio" name="role" value="user" ${userForEdit.role.equals("user")?'checked="checked"':''}> user<br/>
                <input type="radio" name="role" value="admin" ${userForEdit.role.equals("admin")?'checked="checked"':''} аdmin</td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">      Save      </button></td>
        </tr>
    </table>
</form>
<div>
    <button onclick="location.href='/admin/users'">See all users</button>
</div>
<br>
<br>
</body>
</html>
