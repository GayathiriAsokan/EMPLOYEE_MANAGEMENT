<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<p><%= request.getAttribute("status")%></p>
<p><a href="/Demo1/EmployeeController/Insert?mode=1">INSERT</a>
<p><a href="/Demo1/EmployeeController/Update?mode=2">UPDATE</a>
<p><a href="/Demo1/EmployeeController/Delete?mode=3">DELETE</a>
<p><a href="/Demo1/EmployeeController/ViewAll">DISPLAY EMPLOYEE DETAILS</a>
<p><a href="/Demo1/EmployeeController/View?mode=4">DISPLAY EMPLOYEE</a>
</body>
</html>