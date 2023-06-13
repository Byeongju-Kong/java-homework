<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<table border="1">
    <tr>
        <th><spring:message code="idNumber"/></th>
        <th><spring:message code="memberName"/></th>
        <th><spring:message code="phoneNumber"/></th>
        <th><spring:message code="role"/></th>
        <th>삭제</th>
    </tr>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.idNumber}</td>
            <td>${member.name}</td>
            <td>${member.phoneNumber}</td>
            <td>${member.role}</td>
            <td><button onclick="deleteMember(${member.id})">삭제하기</button></td>
        </tr>
    </c:forEach>
</table>
<hr>
<script>
    function deleteMember(memberId){
        fetch("/members?deletedMemberId=" + memberId, {
            method: "DELETE",
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
