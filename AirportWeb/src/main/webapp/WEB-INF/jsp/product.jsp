<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<title>Login page</title>
</head>
<body>
	<h1>Welcome Nisha!!!!</h1>

	<a href="logout.do">Logout</a>
	<form:form method="POST" modelAttribute="productData"
		action="submitProduct.do">
		<table border="1" align="center">

			<tr>
				<td>Product Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Product Desc :</td>
				<td><form:input path="productDesc" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset" align="right"></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<br>
	<br>


	<table border="1" align="center">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Desc</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:choose>
			<c:when test="${empty productList}">
				<h2>
					<c:out value="Record Not Found.."></c:out>
				</h2>
			</c:when>
			<c:otherwise>
				<c:forEach items="${productList}" var="name">
					<tr>
						<td><c:out value="${name.productId}" /></td>
						<td><c:out value="${name.productName}" /></td>
						<td><c:out value="${name.productDesc}" /></td>
						<td><c:out value="${name.price}" /></td>
						<td><c:out value="${name.quantity}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>