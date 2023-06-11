<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>내 정보 수정</title></head>
<body>
<p>이름 <input type="text" id=name name=name width="12" size="10" value="${memberInfo.name}" disabled></p><br>
<p>비밀번호 <input type="text" id=password name=password width="12" size="10" value="${memberInfo.password}"></p><br>
<p>학번 <input type="text" id=idNumber name=idNumber width="12" size="10" value="${memberInfo.idNumber}" disabled></p><br>
<p>전화번호 <input type="text" id=phoneNumber name=phoneNumber width="12" size="10" value="${memberInfo.phoneNumber}"></p><br>
<p>역할 <input type="text" id=role name=role width="12" size="10" value="${memberInfo.role}" disabled></p><br>
<button onclick="modify()">수정하기</button>
<hr>
<button onclick="location.replace('/')">홈으로 돌아가기</button>
<script>
    function modify(){
        fetch('/members', {
            method: "PATCH",
            body: JSON.stringify({
                password: document.getElementById("password").value,
                phoneNumber: document.getElementById("phoneNumber").value,
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
                    location.replace('/members/my-info');
                }
            })
    }
</script>
</body>
</html>
