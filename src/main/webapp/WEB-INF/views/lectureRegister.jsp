<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>강의 등록페이지</title></head>
<body>
<h1>강의 등록페이지</h1>
<hr>
<p>강의명 <input type="text" id=lectureName name=lectureName width="12" size="10"></p><br>
<p>학점 <input type="text" id=credit name=credit width="12" size="10"></p><br>
<button onclick="move()">등록하기</button>
<hr>
<button onclick="location.replace('/')">홈으로 돌아가기</button>
<script>
    function move() {
        let name = document.getElementById("lectureName").value;
        let credit = document.getElementById("credit").value;
        fetch('/lectures', {
            method: "POST",
            body: JSON.stringify({
                name: name,
                credit: credit,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(async res => {
                let body = await res.json();
                if (res.status === 200) {
                    alert(body.message);
                    location.replace('/page/lectures/professor');
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
