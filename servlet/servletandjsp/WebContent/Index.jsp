<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE MANAGEMENT</title>
<script>
function employeeFunction() {
	if (document.getElementById("project").checked) {
		alert(document.getElementById("ProjectDivision").style.visibility='visible');
		alert(document.getElementById("EmployeeDivision").style.visibility='hidden');
	} else if (document.getElementById("employee").checked) {
		alert(document.getElementById("EmployeeDivision").style.visibility='visible');
		alert(document.getElementById("ProjectDivision").style.visibility='hidden');
	}
}
</script>
</head>
<body>
<h1>EMPLOYEE MANAGEMENT</h1>
<input type="radio" id ="employee" name="employeeApplication" checked="checked" onchange="employeeFunction()">
<label for ="employee">EMPLOYEE DETAILS</label><br>
<input type="radio" id ="project" name="employeeApplication" onchange="employeeFunction()">
<label for ="project">PROJECT DETAILS</label><br>
<div id="EmployeeDivision">
<h2>Employee Details</h2>
<p><a href="/Demo1/EmployeeController?mode=1">INSERT</a>
<p><a href="/Demo1/EmployeeController?mode=2">UPDATE</a>
<p><a href="/Demo1/EmployeeController?mode=3">DELETE</a>
<p><a href="/Demo1/ViewAllEmployee">DISPLAY EMPLOYEE DETAILS</a>
<p><a href="/Demo1/EmployeeController?mode=4">DISPLAY EMPLOYEE</a>
<p><a href="/Demo1/AddEmployeeToProject?mode=5"> AddEmployeeToProject</a>
</div>
<div id="ProjectDivision" style="visibility: hidden;">
<h2>Project Details</h2>
<p><a href="/Demo1/ProjectController?mode=1">INSERT</a>
<p><a href="/Demo1/ProjectController?mode=2">UPDATE</a>
<p><a href="/Demo1/ProjectController?mode=3">DELETE</a>
<p><a href="/Demo1/ViewAllProject">DISPLAY PROJECT DETAILS<</a>
<p><a href="/Demo1/ProjectController?mode=4">DISPLAY PROJECT</a>
<p><a href="/Demo1/AddProjectToEmployee?mode=5"> AddProjectToEmployee</a>
</div>
</body>
</html>
