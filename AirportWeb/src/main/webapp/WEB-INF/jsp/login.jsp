<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body topmargin="2">
	<form:form method="POST" modelAttribute="loginData"
		action="verifyLogin.do">
		<pre>
		Language :		 <a href="?language=screen_en">English</a>|<a href="?language=screen_hi">Hindi</a>|<a
				href="?language=screen_ch">Chinese</a>
		<table border="3" align="center">
		<tr>
			<td><spring:message code="label.em" /> : <form:input
							path="emailId" /></td>	
		</tr>
		<tr>
			<td><spring:message code="label.pwd" /> : <form:password
							path="password" /></td>
		</tr>
						  					  		
			<tr>
					<td> <input type="submit"
						value="<spring:message code="label.sb"/>" /></td>
				</tr>
		</pre>											 	
	</table>
		
	</form:form>
	<a href="registration.do">Click for SignUp</a>
</body>
</html>