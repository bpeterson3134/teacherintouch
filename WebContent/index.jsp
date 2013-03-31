<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher In Touch</title>
</head>
<body>
	<%--JSP scriptlet --%>
	<%
		String loginID = "1";
	%>
	<H1 align="center">Welcome to <u><i>Your Name</i></u>'s Classroom!</u></H1>
	<a href="students?teacherID=<%=loginID%>">Students</a><br>
	<a href="guardians">Guardians</a><br>
	<a href="gradeBook">GradeBook</a><br>
	<a href="faq">FAQ</a><br>
</body>
</html>