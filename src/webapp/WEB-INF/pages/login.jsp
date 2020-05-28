<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Login Window</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" placeholder="login" name="j_username"/>
    <input type="password" placeholder="password" name="j_password"/>
    <input type="submit"/>
</form>
<h1>
<c:forEach var="msq" items="${messages}">
    <p>${msq}</p>
</c:forEach>
</h1>
</body>
</html>
