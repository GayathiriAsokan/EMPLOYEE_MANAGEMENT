<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<p><a href="/EmployeeController/Insert?mode=1">INSERT</a>
<p><a href="/EmployeeController/Update?mode=2">UPDATE</a>
<p><a href="/EmployeeController/Delete?mode=3">DELETE</a>
<p><a href="/EmployeeController/ViewAll">DISPLAY EMPLOYEE DETAILS</a>
<p><a href="/EmployeeController/View?mode=4">DISPLAY EMPLOYEE</a>
<p>${status}</p>
</body>
</html>