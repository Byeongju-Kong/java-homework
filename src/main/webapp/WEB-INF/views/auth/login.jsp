<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<p>학번 <input type="text" id="idNumber" name=idNumber width="12" size="10"></p><br>
<p>비밀번호 <input type="text" id="password" name=password width="12" size="10"></p><br>
<button onclick="move()">확인</button>
<script type="text/javascript">
    function move() {
        let idNumber = document.getElementById("idNumber").value;
        let password = document.getElementById("password").value;
        fetch('/login', {
            method: "POST",
            body: JSON.stringify({
                idNumber: idNumber,
                password: password
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
</body>
</html>
