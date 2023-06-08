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
<% request.setCharacterEncoding("UTF-8"); %> <form:form action="/orders/register" modelAttribute="order">
    <p><label>
        <spring:message code="customerId"/>:<br> <form:input path="customerId"/> <form:errors path="customerId"/>
    </label></p>
    <p><label>
        <spring:message code="bookId"/>:<br> <form:input path="bookId"/> <form:errors path="bookId"/>
    </label></p>
    <button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<hr>
<a href="/"><spring:message code="mainPage"/></a>
</html>
