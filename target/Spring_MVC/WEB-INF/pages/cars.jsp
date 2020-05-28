<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All cars</title>
</head>
<body>
<%--<div align="center">--%>
<%--        <c:forEach var="msq" items="${messages}">--%>
<%--            <h2>${msq}</h2>--%>
<%--        </c:forEach>--%>
<%--            <s:message code="greeting"></s:message>--%>
<%--<br>--%>
<%--</div>--%>
<div align="center">
    <table border="1" cellpadding="5">
        <c:forEach var="msq" items="${messages}">
            <h1>${msq}</h1>
        </c:forEach>
        <tr>
            <th>Model</th>
            <th>Number</th>
            <th>Max. Speed</th>
            <th>Color</th>
        </tr>
<%--        <jsp:useBean id="carList" scope="request" type="java.util.List"/>--%>
        <c:forEach var = "car" items="${carList}">
            <tr>
                <td>${car.model}</td>
                <td>${car.number}</td>
                <td>${car.maxSpeed}</td>
                <td>${car.color}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
</body>
</html>
