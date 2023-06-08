<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
<h1><spring:message code="booksPage"/></h1>
<hr>
<table border="1">
    <tr>
        <th><spring:message code="memberName"/></th>
        <th><spring:message code="idNumber"/></th>
        <th><spring:message code="phoneNumber"/></th>
        <th><spring:message code="role"/></th>
    </tr>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${book.idNumber}</td>
            <td>${book.name}</td>
            <td>${book.phoneNumber}</td>
            <td>${book.role}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="/books/register"><spring:message code="bookRegisterPage"/></a>
<a href="/"><spring:message code="mainPage"/></a>
</body>
</html>
