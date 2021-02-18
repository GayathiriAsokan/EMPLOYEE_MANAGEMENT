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
<p><a href="/ProjectController/Insert?mode=1">INSERT</a>
<p><a href="/ProjectController/Update?mode=2">UPDATE</a>
<p><a href="/ProjectController/ViewAllProject">DISPLAY PROJECT DETAILS</a>
<p><a href="/ProjectController/View?mode=4">DISPLAY PROJECT</a>
<p><a href="/ProjectController/AddEmployee?mode=5">ADD PROJECT TO EMPLOYEE</a>
</body>
</html>