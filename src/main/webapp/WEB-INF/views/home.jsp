<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String role = (String) session.getAttribute("role");
%>
<body>
<% if (role == null) {%>
<h1><c:out value="학점 관리 서비스을 이용하기 위해 로그인을 해주세요."/></h1>
<button onclick="location.replace('/page/login')">로그인</button>
<%} else {%>
<h1><c:out value="당신은 ${role} 입니다."/></h1>
<button onclick="location.replace('/members/my-info')">마이페이지</button>
<button onclick="logout()">로그아웃</button>
<% if(role.equals("ADMIN")){%>
<button onclick="location.replace('/page/members')">회원 등록</button>
<button onclick="location.replace('/members?role=STUDENT')">학생 목록 조회</button>
<button onclick="location.replace('/members?role=PROFESSOR')">교수 목록 조회</button>
<button onclick="location.replace('/members-list')">회원 전체 목록 조회</button>
<%} else if (role.equals("PROFESSOR")) {%>
<button onclick="location.replace('/page/lectures-register')">강의 등록</button>
<button onclick="location.replace('/page/lectures/professor')">내가 개설한 강의 목록</button>
<button onclick="location.replace('/page/lectures')">전체 강의 목록</button>
<%} else {%>
<button onclick="location.replace('/page/grades')">성적 확인하기</button>
<button onclick="location.replace('/page/lectures')">전체 강의 목록</button>
<%}%>
<%}%>
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
