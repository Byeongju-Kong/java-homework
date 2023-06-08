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
<form:form action="/books/register" modelAttribute="book">
<p><label> <spring:message code="bookName"/>:<br> <form:input path="bookName"/> <form:errors path="bookName"/> </label>
</p>
<p><label> <spring:message code="publisher"/>:<br> <form:input path="publisher"/> <form:errors path="publisher"/>
</label></p>
<p><label> <spring:message code="price"/>:<br> <form:input path="price"/> <form:errors path="price"/> </label></p>
<p><label> <spring:message code="bookType"/>:<br> <form:input path="type"/> <form:errors path="type"/> </label>
</p>
<p><label> <spring:message code="imageUrl"/>:<br> <form:input path="imageUrl"/> <form:errors path="imageUrl"/>
</label></p>
<button class="btn" type="submit"><spring:message code="submit"/></button>
</form:form>
<hr>
