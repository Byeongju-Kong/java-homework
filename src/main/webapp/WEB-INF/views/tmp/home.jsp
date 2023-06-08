<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><spring:message code="homeMsg"/></h1>
<a href="/customers/register/page"><spring:message code="customerRegisterPage"/></a><br>
<a href="/books/register/page"><spring:message code="bookRegisterPage"/></a><br>
<a href="/orders/register/page"><spring:message code="orderRegisterPage"/></a>
</body>
</html>
