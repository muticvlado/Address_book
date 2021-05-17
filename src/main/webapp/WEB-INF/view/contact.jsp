<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/main.css">
</head>
<body>

<jsp:include page="include/navigation.jsp"></jsp:include>

<h3>Contact form</h3>

<div id="form">
<form:form modelAttribute="contact" action="save-contact">

	<form:hidden path="id"/>
	<table>	
		<tr>
			<td>Name</td>
			<td><form:input path="name"/> &nbsp;&nbsp; <form:errors path="name" cssStyle="color: red"/></td>			
		</tr>
		<tr>
			<td>Surname</td><td><form:input path="surname"/></td>
		</tr>
		<tr>
			<td>Phone</td><td><form:input path="phone"/></td>
		</tr>
		<tr>
			<td>Email</td><td><form:input path="email"/> &nbsp;&nbsp; <form:errors path="email" cssStyle="color: red"/></td>
		</tr>
		<tr>
			<td>Notice</td><td><form:textarea path="notice" rows="5" cols="24"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" style="padding: 10px"/></td>
		</tr>	
	</table>

</form:form>
</div>

</body>
</html>