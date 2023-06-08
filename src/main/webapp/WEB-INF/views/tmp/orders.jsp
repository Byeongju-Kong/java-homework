<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
<h1><spring:message code="ordersPage"/></h1>
<hr>
<table border="1">
    <tr>
        <th><spring:message code="orderId"/></th>
        <th><spring:message code="customerId"/></th>
        <th><spring:message code="bookId"/></th>
        <th><spring:message code="orderDate"/></th>
    </tr>
    <c:forEach var="orders" items="${orders}">
    <tr>
        <td>${orders.id}</td>
        <td>${orders.customerId}</td>
        <td>${orders.bookId}</td>
        <td>${orders.orderDate}</td>
    </tr>
    </c:forEach>
</table>
<hr>
<a href="/orders/register"><spring:message code="orderRegisterPage"/></a>
<a href="/"><spring:message code="mainPage"/></a>
</body>
</html>
