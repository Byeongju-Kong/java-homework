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
<h1><c:out value="강의 상세보기"/></h1>
<c:out value="강의명: ${lecture.name}"/><br>
<c:out value="담당교수 이름: ${lecture.professorName}"/><br>
<c:out value="담당교수 전화번호: ${lecture.professorPhoneNumber}"/><br>
<c:out value="학점: ${lecture.credit}"/><br>

<% if (role.equals("PROFESSOR")) {%>
<hr>
<h2>수강 내역</h2>
<table border="1">
    <tr>
        <th>학생 이름</th>
        <th>학생 학번</th>
        <th>성적 입력</th>
    </tr>
    <c:forEach var="student" items="${lecture.students}">
        <tr>
            <td>${student.name}</td>
            <td>${student.idNumber}</td>
            <td><button type="button" onclick="location.href='/grade?lectureId=' + ${param.id} + '&&studentId=' + ${student.id}">성적 입력하기</button></td>
        </tr>
    </c:forEach>
</table>
<%}%>

</body>
</html>