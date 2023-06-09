<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <title>Title</title></head>
<body>
<h1></h1>
<hr>
    <% request.setCharacterEncoding("UTF-8"); %>
<form:form action="/books/register" modelAttribute="loginRequest">
<p><label>
    <spring:message code="idNumber"/>:<br> <form:input path="idNumber"/> <form:errors path="idNumber"/>
</label></p>
<p><label>
    <spring:message code="password"/>:<br> <form:input path="password"/> <form:errors path="publisher"/>
</label></p>
<button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<hr>
