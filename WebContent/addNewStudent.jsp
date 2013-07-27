<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher In Touch</title>

<script language="JavaScript">
	function validate(form) {
		document.getElementById("fName_error_msg").innerHTML = "";
		document.getElementById("lName_error_msg").innerHTML = "";
		document.getElementById("gender_error_msg").innerHTML = "";
		var checked=false;
		var radios = document.getElementsByName("gender");

		for(var i=0; i < radios.length; i++){
		    if(radios[i].checked) {
		        checked=true;
			}
		}
		if (form.firstName.value == "") {
			//form.firstName.focus();
			document.getElementById("fName_error_msg").innerHTML = "First Name is required";
		} 
		if (form.lastName.value == "") {
			//form.lastName.focus();
			document.getElementById("lName_error_msg").innerHTML = "Last Name is required";
		} else if (!checked) {
			//radios[0].focus();
			document.getElementById("gender_error_msg").innerHTML = "Gender is required";
		} else if (form.grade.value == "") {
			//form.grade.focus();
		} else {
			return true;
		}
		return false;
	}  
</script> 
</head>
<body>
	<form action="addNewStudentServlet?teacherID=2" onsubmit="return validate(this);" method="post">
		* Required<br>
		First Name: <input type="text" name="firstName">* <span id="fName_error_msg" style="color:red"></span><br>
		Last Name: <input type="text" name="lastName">* <span id="lName_error_msg" style="color:red"></span><br>
		Gender: <input type="radio" name="gender" value="M">M
				<input type="radio" name="gender" value="F">F* <span id="gender_error_msg" style="color:red"></span><br>
		Grade:  <select name="grade">
					<option value="2" selected>2
					<option value="3">3
					<option value="4">4
					<option value="5">5
				</select>*<br>
		Homeroom teacher: None<br><br>
		<input type="submit" value="Add">
		
	</form>

</body>
</html>