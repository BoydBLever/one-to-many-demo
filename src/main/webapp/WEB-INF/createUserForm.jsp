<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donations</title>
</head>
<body>
<h1>Create user</h1>
<form:form action="/users/new" method="POST" modelAttribute="newUser">
  <p>
        <form:label path="userName">Username:</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
     <p>
        <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
    <button type="submit">Add new user</button>
</form:form>
</body>
</html>