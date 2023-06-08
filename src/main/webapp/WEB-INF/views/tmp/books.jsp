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
        <th><spring:message code="bookId"/></th>
        <th><spring:message code="bookName"/></th>
        <th><spring:message code="publisher"/></th>
        <th><spring:message code="price"/></th>
        <th><spring:message code="bookType"/></th>
        <th><spring:message code="imageUrl"/></th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.publisher}</td>
            <td>${book.price}</td>
            <td>${book.type}</td>
            <td>${book.imageUrl}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="/books/register"><spring:message code="bookRegisterPage"/></a>
<a href="/"><spring:message code="mainPage"/></a>
</body>
</html>
