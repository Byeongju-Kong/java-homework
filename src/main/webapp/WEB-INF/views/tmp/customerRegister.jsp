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
<form:form action="/customers/register" modelAttribute="customer">
    <p><label>
        <spring:message code="username"/>:<br> <form:input path="username"/> <form:errors path="username"/>
    </label></p>
    <p><label>
        <spring:message code="password"/>:<br> <form:input path="password"/> <form:errors path="password"/>
    </label></p>
    <p><label>
        <spring:message code="name"/>:<br> <form:input path="name"/> <form:errors path="name"/>
    </label></p>
    <p><label>
        <spring:message code="address"/>:<br> <form:input path="address"/> <form:errors path="address"/>
    </label></p>
    <p><label>
        <spring:message code="phoneNumber"/>:<br> <form:input path="phoneNumber"/> <form:errors path="phoneNumber"/>
    </label></p>
    <button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<hr>
<a href="/"><spring:message code="mainPage"/></a>
</body>
</html>
