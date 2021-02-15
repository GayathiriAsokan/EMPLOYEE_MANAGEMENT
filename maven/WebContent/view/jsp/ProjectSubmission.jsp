<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project submit</title>
</head>
<body>
<p><%= request.getAttribute("status")%></p>
<p><a href="/Demo1/ProjectController/Insert?mode=1">INSERT</a>
<p><a href="/Demo1/ProjectController/Update?mode=2">UPDATE</a>
<p><a href="/Demo1/ProjectController/ViewAllProject">DISPLAY PROJECT DETAILS</a>
<p><a href="/Demo1/ProjectController/View?mode=4">DISPLAY PROJECT</a>
<p><a href="/Demo1/ProjectController/AddEmployee?mode=5">ADD PROJECT TO EMPLOYEE</a>
</body>
</html>