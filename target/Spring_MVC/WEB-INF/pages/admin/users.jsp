<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <c:forEach var ="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.age}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>
                    <a href="edit?id=<c:out value='${user.id}'/>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${user.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='/admin/add'">Add new user</button>
    </div>
</div>
</body>
</html>
