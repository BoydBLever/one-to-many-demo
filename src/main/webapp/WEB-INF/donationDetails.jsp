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
<title>Donations</title>
</head>
<body>
	<h1>Donation Details</h1>
	<h2>Donation name:
	<c:out value="${donation.donationName }"/>
	</h2>
	<h2>Quantity:
	<c:out value="${donation.quantity }"/>
	</h2>
	<h2>Description:
	<c:out value="${donation.description }"/>
	</h2>
	<h2>Donor:
	<c:out value="${donation.donor.userName }"/>
	</h2>
	<h2> Contact the donor at
	<c:out value="${donation.donor.email }"/>
	</h2>
	
	<form action="/donations/delete/${donation.id}" method="POST">
	<input type="hidden" name="_method" value="delete" />
	<button type="submit"> Delete</button>
	</form>
</body>
</html>