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
<c:out value="비밀번호: ${memberInfo.password}"/><br>
<c:out value="학번: ${memberInfo.idNumber}"/><br>
<c:out value="전화번호: ${memberInfo.phoneNumber}"/><br>
<c:out value="역할: ${memberInfo.role}"/><br>
<button onclick="location.replace('/members/my-info/modify')">내정보 수정</button>

<% if (role.equals("STUDENT")) {%>
<hr>
<h2>수강 내역</h2>
<table border="1">
    <tr>
        <th>강의명</th>
        <th>교수이름</th>
        <th>강의취소</th>
    </tr>
    <c:forEach var="lecture" items="${memberInfo.lectures}">
        <tr>
            <td>${lecture.name}</td>
            <td>${lecture.professorName}</td>
            <td><button onclick="cancel(${lecture.id})">취소하기</button></td>
        </tr>
    </c:forEach>
</table>
<%}%>
<hr>
<button onclick="location.replace('/')">홈으로 돌아가기</button>
<button onclick=logout()>로그아웃</button>
<script>
    function cancel(lectureId){
        fetch('/lectures/student', {
            method: "DELETE",
            body: JSON.stringify({
                lectureId: lectureId,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 400) {
                    alert(body.message);
                    location.reload();
                }
                if (res.status === 200) {
                    alert(body.message);
                    location.reload();
                }
            })
    }
</script>
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