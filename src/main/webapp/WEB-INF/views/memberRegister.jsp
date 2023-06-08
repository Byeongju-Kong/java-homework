<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>회원 등록페이지</title></head>
<body>
<hr>
    <% request.setCharacterEncoding("UTF-8"); %>
<form:form action="/member" modelAttribute="memberRegisterRequest">
<p><label>
    <spring:message code="idNumber"/>:<br> <form:input path="idNumber"/> <form:errors path="idNumber"/>
</label></p>
<p><label>
    <spring:message code="password"/>:<br> <form:input path="password"/> <form:errors path="password"/>
</label></p>
<p><label>
    <spring:message code="memberName"/>:<br> <form:input path="memberName"/> <form:errors path="memberName"/>
</label></p>
<p><label>
    <spring:message code="phoneNumber"/>:<br> <form:input path="phoneNumber"/> <form:errors path="phoneNumber"/>
</label></p>
<p><label>
    <spring:message code="role"/>:<br> <form:input path="role"/> <form:errors path="role"/>
</label></p>
<button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<hr>
