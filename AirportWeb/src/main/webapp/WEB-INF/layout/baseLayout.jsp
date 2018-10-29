<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<table>
		<tr>
			<tiles:insertAttribute name="header" />
		</tr>

		<tr>
			<tiles:insertAttribute name="menu" />
		</tr>

		<tr>
			<tiles:insertAttribute name="body" />
		</tr>

		<tr>
			<tiles:insertAttribute name="footer" />
		</tr>

	</table>
</body>
</html>
