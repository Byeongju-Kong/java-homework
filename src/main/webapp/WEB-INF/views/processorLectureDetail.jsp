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
<c:out value="수강 학생 수: ${lecture.students.size()}"/><br>
<c:out value="점수 평균: 해야함"/><br>

<% if (role.equals("PROFESSOR")) {%>
<hr>
<h2>강의 학생 목록</h2>
<table border="1">
    <tr>
        <th>학생 이름</th>
        <th>학생 학번</th>
        <th>성적</th>
        <th>성적저장</th>
    </tr>
    <c:forEach var="student" items="${lecture.students}">
        <tr>
            <td>${student.name}</td>
            <td>${student.idNumber}</td>
            <td><input type="text" id="${student.id}${param.id}" value="${student.grade}"></td>
            <c:if test="${student.grade ne 0.0}">
                <td><button onclick="modifyGrade(${student.id},${param.id},${student.id}${param.id})">수정하기</button></td>
            </c:if>
            <c:if test="${student.grade eq 0.0}">
                <td><button onclick="registerGrade(${student.id},${param.id},${student.id}${param.id})">입력하기</button></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<%}%><script>
    function registerGrade(studentId, lectureId, grade) {
        fetch('/grade', {
            method: "POST",
            body: JSON.stringify({
                studentId: studentId,
                lectureId: lectureId,
                grade: document.getElementById(eval("'"+grade+"'")).value,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 201) {
                    alert(body.message);
                    location.reload();
                }
                if (res.status === 400) {
                    alert(body.message);
                    location.reload();
                }
            })
    }
</script>
<script>
    function modifyGrade(studentId, lectureId, grade) {
        fetch('/grade', {
            method: "PATCH",
            body: JSON.stringify({
                studentId: studentId,
                lectureId: lectureId,
                grade: document.getElementById(eval("'"+grade+"'")).value,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 200) {
                    alert(body.message);
                    location.reload();
                }
                if (res.status === 400) {
                    alert(body.message);
                    location.reload();
                }
            })
    }
</script>
<hr>
<button onclick="location.replace('/')">홈으로 돌아가기</button>
<button onclick=logout()>로그아웃</button>
<script>
    function logout(){
        fetch('/logout', {
            method: "GET"
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 200) {
                    alert(body.message);
                    location.replace('/');
                }
                if (res.status === 403) {
                    alert(body.message);
                    location.reload();
                }
            })
    }
</script>
</body>
</html>