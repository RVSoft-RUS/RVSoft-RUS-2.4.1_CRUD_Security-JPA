<%--
  Created by IntelliJ IDEA.
  User: MAC
  Date: 15.05.2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<h2>
    <c:out value='${errorText}' />
</h2>

<br>
<br>
<div>    <!-- buttons holder -->
    <button onclick="location.href='/admin/users'">  Go back  </button>
</div>
</body>
</html>
