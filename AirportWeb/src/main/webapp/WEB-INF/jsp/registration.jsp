<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form:form action="userRegistration.do"
		modelAttribute="registrationData" method="POST">
		<table border="3" align="center" cellpadding="2" cellspacing="2">
			<tr>

				<td>First Name :</td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" />
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><form:input path="emailId" />
				<td><form:errors path="emailId" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" />
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><form:input path="mobileNo" />
				<td><form:errors path="mobileNo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value=Register></td>
			</tr>
		</table>
	</form:form>
</body>
</html>