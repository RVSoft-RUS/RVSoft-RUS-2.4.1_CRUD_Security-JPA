<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form action="${pageContext.request.contextPath}/admin/add" method="post">
    <table border="0" cellpadding="5">
        <tr>
            <td><label>Name:</label></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><label>Surname:</label></td>
            <td><input type="text" name="surname"></td>
        </tr>
        <tr>
            <td><label>Age:</label></td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><label>Role:</label></td>
            <td><input type="radio" name="role" value="user" checked> user<br/>
                <input type="radio" name="role" value="admin"> admin<br/></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">   Add   </button></td>
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
