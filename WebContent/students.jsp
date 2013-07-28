<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher In Touch</title>
<script src="scripts/jquery-1.10.2.min.js" type="text/javascript">
</script>
<script type="text/javascript">
var rowPriorToEdit = null;
function editRow(row) {	
	/*
	* If another row is currently being editted then disable the edit with original text
	*/
	var tableID = $(row).parent().closest("table").attr('id');
	$('#' + tableID + ' tr.currentEdit').each(function() {
		revert(this, rowPriorToEdit);
		rowPriorToEdit=null;
		$(this).removeClass("currentEdit");
	});

	$(row).addClass("currentEdit");
	if(rowPriorToEdit == null) {
		rowPriorToEdit=$(row).html();
	}
    $('td.edit',row).each(function() {//td.edit:not(:last-child)
    	if($(this).find("input").length == 0) {
         	$(this).html('<input id="editBox" type="text" value="' + $(this).html() + '" />');
         	$('#editBox').focus();
    	}
    });
    /*
    * Change 'Edit' link to 'Save'
    */
    $('#editLink',row).each(function() {
         	$(this).html('<a id="saveLink" href="#">Save<\/a><\/td>');//backslash prevents html tags being read as markup
    	
    });

}
function saveRow(row) {
	var rowData = {};
	rowData.id=$(row).attr('id');
	$("td:not(:last-child)", row).each(function() {
		//alert("value="+$(this).find('input').val());
		if($(this).find("input").length > 0) {
			rowData[$(this).attr('id')] = $(this).find('input').val();
		} else {
			//non editable column
			rowData[$(this).attr('id')] = $(this).html();
		}
	});
    $.ajax({
    	type: "POST",
    	url:"updateStudentServlet",
    	data: rowData,
    	success : function(data, textStatus, jqXHR) {
    		$("td:not(:last-child)", row).each(function() {
    			//alert("value="+$(this).find('input').val());
    			$(this).html(data[$(this).attr('id')]);
    			//alert("td="+$(this).attr('id'));
    			//rowData[$(this).attr('id')] = $(this).find('input').val();
    		});
    		
    		$('#saveLink',row).each(function() {
    	       	$(this).html('<a id="editLink" href="#">Edit<\/a><\/td>');
    	    	
    	    });
    	      }, 
    	error : function(data) {
    		//TODO display error to user
    		revert(row, rowPriorToEdit);
    		rowPriorToEdit = null;
	     	},
    	complete : function(obj, status) {
    		//alert("status="+status);
    	      } 
    });
    

}
function deleteRow(row) {	
	var confirmed = confirm("Delete record?");
	if (confirmed) {
		var rowData = {};
		rowData.id=$(row).attr('id');
		$("td:not(:last-child)", row).each(function() {
			if($(this).find("input").length > 0) {
				rowData[$(this).attr('id')] = $(this).find('input').val();
			} else {
				//non editable column
				rowData[$(this).attr('id')] = $(this).html();
			}
		});
	    $.ajax({
	    	type: "POST",
	    	url:"deleteStudentServlet",
	    	data: rowData,
	    	success : function(data, textStatus, jqXHR) {
	    		$(row).remove();
	    	      }, 
	    	error : function(data) {
	    		//TODO display error to user
	    		alert("Failed to delete record");
		     	},
	    	complete : function(obj, status) {
	    		//alert("status="+status);
	    	      } 
	    });
	}

}
function revert(row, origData) {
	$(row).html(origData);
   	$(row).removeClass("currentEdit");
}
</script>

<script type="text/javascript">
$(document).ready(function(){
	$("body").delegate("#studentsTable [id*=editLink]", "click",function() {			
		editRow($(this).parent().closest("tr"));
		return false;
	});
});
$(document).ready(function(){
	$("body").delegate("#studentsTable [id*=saveLink]", "click",function() {			
		saveRow($(this).parent().closest("tr"));
		return false;
	});
});
$(document).ready(function(){
	$("body").delegate("#studentsTable [id*=deleteLink]", "click",function() {			
		deleteRow($(this).parent().closest("tr"));
		return false;
	});
});
</script>     
</head>
<body>
	<H1 align="center"><i>Teacher's</i> Students</H1>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<c:if test="${not empty students}">
		<table id="studentsTable" align="center" width="700" >
			<tr align="left" valign="top">
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Grade</th>
				<th>Homeroom teacher</th>
			</tr>
		
			<c:forEach var="student" items="${students}" varStatus="status" begin="0" step="1" >
				<tr id="${student.id}" valign="top">
					<td id="firstName" class="edit">${student.firstName}</td>
					<td id="lastName" class="edit">${student.lastName}</td>
					<td id="gender" class="edit">${student.gender}</td>
					<td id="grade" class="edit">${student.grade}</td>
					<td id="homeroomTeacherID" >${student.homeroomTeacherID}</td>
					<td><a id="editLink" href="#">Edit</a></td>
					<td><a id="deleteLink" href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<p align="center">You have ${fn:length(students)} student(s) enrolled in your classroom</p>
	<p align="center"><a href="addNewStudent">Add NEW Student</a></p>
	
</body>
</html>