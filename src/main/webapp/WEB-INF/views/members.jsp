<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title></head>
<body>
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
            <td>${member.idNumber}</td>
            <td>${member.name}</td>
            <td>${member.phoneNumber}</td>
            <td>${member.role}</td>
        </tr>
    </c:forEach>
</table>
<hr>
</body>
</html>
