<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="include/navigation.jsp"></jsp:include>

<h3>Contact list</h3>

<table id="contacts">
	<tr><th>Name</th><th>Surname</th><th>Notice</th><th>Phone</th><th>Email</th><th colspan="2">Action</th></tr>
	<c:forEach var="contact" items="${contacts}">
		<tr>
			<td>${contact.name}</td><td>${contact.surname}</td><td>${contact.notice}</td><td>${contact.phone}</td><td>${contact.email}</td>
			<td><a href="get-update-contact?id=${contact.id}">Update</a></td>
			<td><a href="delete-contact?id=${contact.id}" onclick="return confirm('Delete contact?')">Delete</a></td>
		</tr>
	</c:forEach>
</table>

<br>

<div class="pagination">
	<c:forEach var = "i" begin = "1" end = "${totalPages}">
		<c:if test="${i == currentPage}">
			<a class="active" href='/<c:out value = "${i}"/>'><c:out value = "${i}"/></a>
		</c:if>
		<c:if test="${i != currentPage}">
			<a href='/<c:out value = "${i}"/>'><c:out value = "${i}"/></a>
		</c:if>
	</c:forEach>
</div>
	
</body>
</html>