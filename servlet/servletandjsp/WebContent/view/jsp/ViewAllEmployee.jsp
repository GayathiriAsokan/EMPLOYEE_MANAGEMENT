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
<title>EMPLOYEE MANAGEMENT DETAILS</title>
</head>
<body>
<p><a href="/Demo1/Index.jsp"> HOME</a>
<h1>EMPLOYEE MANAGEMENT DETAILS</h1>
<table>
<tr>
<th>EmployeeID</th>
<th>CompanyName</th>
<th>Designation</th>
<th>Salary</th>
<th>Experience</th>
<th>Status</th>
<th>EmployeeName</th>
<th>PhoneNumber</th>
<th>EmailId</th>
<th>DateOfBirth</th>
<th>Street</th>
<th>City</th>
<th>District</th>
<th>State</th>
<th>PinCode</th>
<th>AddressType</th>
<th>PermanentStreet</th>
<th>PermanentCity</th>
<th>PermanentDistrict</th>
<th>PermanentState</th>
<th>PermanentPinCode</th>
<th>PermanentAddressType</th>
<th>ProjectID</th>
<th>ProjectName</th>
<th>ProjectManager</th>
<th>Technology</th>
<th>ProjectType</th>
<th>StartDate</th>
<th>EndDate</th>
<th>ActualEndDate</th>
</tr>
<% EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
List <Employee> employeeList = employeeService.getAllEmployee();
for (int index = 0 ; index < employeeList.size() ; index ++) {
        Employee employee = employeeList.get(index);%>
        <tr>
	<td> <%= employee.getEmployeeId() %></td>
	<td> <%= employee.getCompanyName() %></td>
	<td> <%= employee.getDesignation() %></td>
    <td> <%= employee.getSalary() %></td>
    <td> <%= employee.getExperience() %></td>
    <td> <%= employee.getStatus() %></td>
	<td> <%= employee.getPersonalDetails().getName() %></td>
	<td> <%= employee.getPersonalDetails().getPhoneNumber() %></td>
	<td> <%= employee.getPersonalDetails().getEmailId() %></td>
	<td> <%= employee.getPersonalDetails().getDateOfBirth() %></td>
	<% List <Address> addressList = new ArrayList <Address> (employee.getPersonalDetails().getAddressSet());%> 
	<td> <%= addressList.get(0).getStreet()%> </td>
	<td> <%= addressList.get(0).getCity()%> </td>
	<td> <%= addressList.get(0).getDistrict()%> </td>
	<td> <%= addressList.get(0).getState()%> </td>
	<td> <%= addressList.get(0).getPinCode()%> </td>
	<td> <%= addressList.get(0).getAddressType()%> </td>
	<td> <%= addressList.get(1).getStreet()%> </td>
	<td> <%= addressList.get(1).getCity()%> </td>
	<td> <%= addressList.get(1).getDistrict()%> </td>
	<td> <%= addressList.get(1).getState()%> </td>
	<td> <%= addressList.get(1).getPinCode()%> </td>
	<td> <%= addressList.get(1).getAddressType()%> </td>
	<% List <Project> projectList = new ArrayList <Project> (employee.getProjectSet()); 
	for (int projectIndex = 0 ; projectIndex < projectList.size(); projectIndex ++) {
	if(projectIndex > 0 ) {%>
 </tr>
<tr>
<td> <%= employee.getEmployeeId() %></td>
	<td> <%= employee.getCompanyName() %></td>
	<td> <%= employee.getDesignation() %></td>
    <td> <%= employee.getSalary() %></td>
    <td> <%= employee.getExperience() %></td>
    <td> <%= employee.getStatus() %></td>
	<td> <%= employee.getPersonalDetails().getName() %></td>
	<td> <%= employee.getPersonalDetails().getPhoneNumber() %></td>
	<td> <%= employee.getPersonalDetails().getEmailId() %></td>
	<td> <%= employee.getPersonalDetails().getDateOfBirth() %></td>
	<td> <%= addressList.get(0).getStreet()%> </td>
	<td> <%= addressList.get(0).getCity()%> </td>
	<td> <%= addressList.get(0).getDistrict()%> </td>
	<td> <%= addressList.get(0).getState()%> </td>
	<td> <%= addressList.get(0).getPinCode()%> </td>
	<td> <%= addressList.get(0).getAddressType()%> </td>
	<td> <%= addressList.get(1).getStreet()%> </td>
	<td> <%= addressList.get(1).getCity()%> </td>
	<td> <%= addressList.get(1).getDistrict()%> </td>
	<td> <%= addressList.get(1).getState()%> </td>
	<td> <%= addressList.get(1).getPinCode()%> </td>
	<td> <%= addressList.get(1).getAddressType()%> </td>
<td> <%= projectList.get(projectIndex).getProjectId() %> </td>
	<td><%= projectList.get(projectIndex).getProjectName() %> </td>
	<td><%= projectList.get(projectIndex).getProjectManager() %> </td>
	<td><%= projectList.get(projectIndex).getTechnology() %> </td>
	<td><%= projectList.get(projectIndex).getProjectType() %> </td>
	<td><%= projectList.get(projectIndex).getStartDate() %> </td>
	<td><%= projectList.get(projectIndex).getEndDate() %> </td>
	<td><%= projectList.get(projectIndex).getActualEndDate() %> </td>
	</tr>
<% }
 else{ %>
    <td> <%= projectList.get(projectIndex).getProjectId() %> </td>
	<td><%= projectList.get(projectIndex).getProjectName() %> </td>
	<td><%= projectList.get(projectIndex).getProjectManager() %> </td>
	<td><%= projectList.get(projectIndex).getTechnology() %> </td>
	<td><%= projectList.get(projectIndex).getProjectType() %> </td>
	<td><%= projectList.get(projectIndex).getStartDate() %> </td>
	<td><%= projectList.get(projectIndex).getEndDate() %> </td>
	<td><%= projectList.get(projectIndex).getActualEndDate() %> </td>
	</tr>
	<% } } }%>
</table>
</body>
</html>