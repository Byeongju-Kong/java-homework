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
<h2>강의 학생 목록</h2>
<table border="1">
    <tr>
        <th>학생 이름</th>
        <th>학생 학번</th>
        <th>성적</th>
        <th>성적 저장하기</th>
    </tr>
    <c:forEach var="student" items="${lecture.students}">
        <tr>
            <td>${student.name}</td>
            <td>${student.idNumber}</td>
            <td><input type="text" id="studentgrade" value="${student.grade}"></td>
            <td><button onclick="registerGrade(${student.id},${param.id})">저장하기</button></td>
        </tr>
    </c:forEach>
</table>
<%}%><script>
    function registerGrade(studentId, lectureId) {
        fetch('/grade', {
            method: "POST",
            body: JSON.stringify({
                studentId: studentId,
                lectureId: lectureId,
                grade: document.getElementById("studentgrade").value,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(async res => {
                if (res.status === 201) {
                    alert("성적 등록 성공");
                    location.reload();
                }
            })
    }
</script>
</body>
</html>