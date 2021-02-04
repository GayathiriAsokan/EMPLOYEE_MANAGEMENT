<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "java.util.List" %>
    <%@ page import = "com.ideas2it.employee.model.Employee" %>
    <%@ page import = "com.ideas2it.employee.service.EmployeeServiceImpl" %>
    <%@ page import = "com.ideas2it.employee.model.Address" %>
     <%@ page import = "com.ideas2it.project.model.Project" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th,td {
border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TABLE WITH EMPLOYEE MANAGEMENT DETAILS</h1>
<table>
<tr>
<th>EmployeeID</th>
<th>EmployeeName</th>
<th>Designation</th>
<th>PhoneNumber</th>
<th>EmailId</th>
<th>Location</th>
<th>ProjectID</th>
<th>ProjectName</th>
</tr>
<tr>
<% EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
List <Employee> employeeList = employeeService.getAllEmployee();%>
	<td> <% employeeList.get(0).getEmployeeId(); %> </td>
	<td> <% employeeList.get(0).getPersonalDetails().getName(); %>
	<td> <% employeeList.get(0).getDesignation(); %>
	<td> <% employeeList.get(0).getPersonalDetails().getPhoneNumber(); %>
	<td> <% employeeList.get(0).getPersonalDetails().getEmailId(); %>
	<td>hfhfg</td>
	<td><% employeeList.get(0).getProjectId();%> </td>
	<td> dnd </td>
</tr>
</table>
</body>
</html>