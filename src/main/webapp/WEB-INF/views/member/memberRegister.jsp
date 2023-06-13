<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>회원 등록페이지</title></head>
<body>
<p>학번 <input type="text" id="idNumber" name=idNumber width="12" size="10"></p><br>
<p>비밀번호 <input type="text" id="password" name=password width="12" size="10"></p><br>
<p>이름 <input type="text" id="name" name=name width="12" size="10"></p><br>
<p>전화번호 <input type="text" id="phoneNumber" name=phoneNumber width="12" size="10"></p><br>
<p>역할(STUDENT or PROFESSOR) <input type="text" id="role" name=role width="12" size="10"></p><br>
<button onclick="move()">저장</button>
<script>
    function move() {
        let idNumber = document.getElementById("idNumber").value;
        let password = document.getElementById("password").value;
        let name = document.getElementById("name").value;
        let phoneNumber = document.getElementById("phoneNumber").value;
        let role = document.getElementById("role").value;
        fetch('/members', {
            method: "POST",
            body: JSON.stringify({
                idNumber: idNumber,
                password: password,
                name: name,
                phoneNumber: phoneNumber,
                role: role
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
                    location.replace('/');
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
