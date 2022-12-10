<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/donations/edit/${donation.id}" method="POST" 
	modelAttribute="donation">
<input type="hidden" name="_method" value="put"/>
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
    <form:hidden path="donor"/>
    </p>
    <button type="submit">Update donation</button>
</form:form>
</body>
</html>