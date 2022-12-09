<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New Donation</h1>
<form:form action="/donations/new" method="POST" modelAttribute="newDonation">
  <p>
        <form:label path="donationName">Donation Name:</form:label>
        <form:errors path="donationName"/>
        <form:input path="donationName"/>
    </p>
     <p>
        <form:label path="quantity">Quantity:</form:label>
        <form:errors path="quantity"/>
        <form:input type="number" path="quantity"/>
    </p>
     <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"></form:textarea>
    </p>
    <p>
    <form:label path="donor">Donor:</form:label>
    <!-- THE CODE BELOW WILL NOT BE HERE AFTER AUTH -->
    <form:select path="donor">
    	<c:forEach var="eachUser" items="${userList}">
    	<form:option value="${eachUser.id}">${eachUser.userName} (${eachUser.email})</form:option>
    	</c:forEach>
    </form:select>
    <form:errors path="donor"/>
    </p>
    <button type="submit">Add new donation</button>
</form:form>
</body>
</html>