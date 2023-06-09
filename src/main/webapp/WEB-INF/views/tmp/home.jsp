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
<p><a href="/page/login">로그인</a></p>
<%} else {%>
<h1><c:out value="당신은 ${role} 입니다."/></h1>
<p><a href="/members/my-info">마이페이지</a></p>
<p><a href="/logout" onclick="alert('로그아웃 완료')">로그아웃</a></p>
<% if(role.equals("ADMIN")){%>
<p><a href="/page/members">회원 등록</a></p>
<p><a href="/members?role=STUDENT">학생 목록 조회</a></p>
<p><a href="/members?role=PROFESSOR">교수 목록 조회</a></p>
<p><a href="/members-list">회원 전체 목록 조회</a></p>
<%}%>
<%}%>

</body>
</html>
