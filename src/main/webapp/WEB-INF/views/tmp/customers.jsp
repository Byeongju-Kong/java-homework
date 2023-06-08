<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title></head>
<body>
<h1><spring:message code="customersPage"/></h1>
<hr>
<table border="1">
    <tr>
        <th><spring:message code="customerId"/></th>
        <th><spring:message code="password"/></th>
        <th><spring:message code="name"/></th>
        <th><spring:message code="phoneNumber"/></th>
        <th><spring:message code="address"/></th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.password}</td>
            <td>${customer.name}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="/customers/register/page"><spring:message code="customerRegisterPage"/></a>
<a href="/"><spring:message code="mainPage"/></a>
</body>
</html>
