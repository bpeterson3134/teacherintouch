<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher In Touch</title>
</head>
<body>
	<H1 align="center"><i>Teacher's</i> Students</H1>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<c:forEach var="student" items="${students}">
		<tr valign="top">
			<td>${student.firstName}</td>
		</tr>
	</c:forEach>
	
	<c:if test="${empty students}">
		<p align="center">You have ${fn:length(students)} student(s) enrolled in your classroom</p>
	</c:if>
	
</body>
</html>