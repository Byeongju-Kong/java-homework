<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String role = (String) session.getAttribute("role");
%>
<body>
<h1><c:out value="마이페이지"/></h1>
<c:out value="이름: ${memberInfo.name}"/><br>
<c:out value="학번: ${memberInfo.idNumber}"/><br>
<c:out value="전화번호: ${memberInfo.phoneNumber}"/><br>
<c:out value="역할: ${memberInfo.role}"/><br>

<% if (role.equals("STUDENT")) {%>
<hr>
<h2>수강 내역</h2>
<table border="1">
    <tr>
        <th>강의명</th>
        <th>교수이름</th>
    </tr>
    <c:forEach var="lecture" items="${memberInfo.lectures}">
        <tr>
            <td>${lecture.name}</td>
            <td>${lecture.professorName}</td>
        </tr>
    </c:forEach>
</table>
<%}%>

</body>
</html>