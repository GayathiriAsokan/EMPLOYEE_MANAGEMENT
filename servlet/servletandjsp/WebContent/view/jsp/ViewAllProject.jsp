<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ideas2it.employee.model.Employee"%>
<%@ page import="com.ideas2it.project.service.ProjectServiceImpl"%>
<%@ page import="com.ideas2it.employee.model.Address"%>
<%@ page import="com.ideas2it.project.model.Project"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>EMPLOYEE MANAGEMENT DETAILS</title>
</head>
<body>
	<h1>EMPLOYEE MANAGEMENT DETAILS</h1>
</head>
<body>
	<table>
		<tr>
			<th>ProjectID</th>
			<th>ProjectName</th>
			<th>ProjectManager</th>
			<th>Technology</th>
			<th>ProjectType</th>
			<th>StartDate</th>
			<th>EndDate</th>
			<th>ActualEndDate</th>
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
		</tr>
		<%
			ProjectServiceImpl projectService = new ProjectServiceImpl();
		List<Project> projectList = projectService.viewProject();
		for (int index = 0; index < projectList.size(); index++) {
			Project project = projectList.get(index);
		%>
		<tr>
			<td><%=project.getProjectId()%></td>
			<td><%=project.getProjectName()%></td>
			<td><%=project.getProjectManager()%></td>
			<td><%=project.getTechnology()%></td>
			<td><%=project.getProjectType()%></td>
			<td><%=project.getStartDate()%></td>
			<td><%=project.getEndDate()%></td>
			<td><%=project.getActualEndDate()%></td>
			<%
				List<Employee> employeeList = new ArrayList<Employee>(project.getEmployeeSet());
			for (int employeeIndex = 0; employeeIndex < employeeList.size(); employeeIndex ++) {
				if (employeeIndex > 0) {
			%>
		</tr>
		<tr>
			<td><%=project.getProjectId()%></td>
			<td><%=project.getProjectName()%></td>
			<td><%=project.getProjectManager()%></td>
			<td><%=project.getTechnology()%></td>
			<td><%=project.getProjectType()%></td>
			<td><%=project.getStartDate()%></td>
			<td><%=project.getEndDate()%></td>
			<td><%=project.getActualEndDate()%></td>
			<td><%=employeeList.get(index).getEmployeeId()%></td>
			<td><%=employeeList.get(index).getCompanyName()%></td>
			<td><%=employeeList.get(index).getDesignation()%></td>
			<td><%=employeeList.get(index).getSalary()%></td>
			<td><%=employeeList.get(index).getExperience()%></td>
			<td><%=employeeList.get(index).getStatus()%></td>
			<td><%=employeeList.get(index).getPersonalDetails().getName()%></td>
			<td><%=employeeList.get(index).getPersonalDetails().getPhoneNumber()%></td>
			<td><%=employeeList.get(index).getPersonalDetails().getEmailId()%></td>
			<td><%=employeeList.get(index).getPersonalDetails().getDateOfBirth()%></td>
			<%
				List<Address> addressList = new ArrayList<Address>(employeeList.get(index).getPersonalDetails().getAddressSet());
			%>
			<td><%=addressList.get(0).getStreet()%></td>
			<td><%=addressList.get(0).getCity()%></td>
			<td><%=addressList.get(0).getDistrict()%></td>
			<td><%=addressList.get(0).getState()%></td>
			<td><%=addressList.get(0).getPinCode()%></td>
			<td><%=addressList.get(0).getAddressType()%></td>
			<td><%=addressList.get(1).getStreet()%></td>
			<td><%=addressList.get(1).getCity()%></td>
			<td><%=addressList.get(1).getDistrict()%></td>
			<td><%=addressList.get(1).getState()%></td>
			<td><%=addressList.get(1).getPinCode()%></td>
			<td><%=addressList.get(1).getAddressType()%></td>
		</tr>
		<%}
			else {  %>
		<td><%=employeeList.get(index).getEmployeeId()%></td>
		<td><%=employeeList.get(index).getCompanyName()%></td>
		<td><%=employeeList.get(index).getDesignation()%></td>
		<td><%=employeeList.get(index).getSalary()%></td>
		<td><%=employeeList.get(index).getExperience()%></td>
		<td><%=employeeList.get(index).getStatus()%></td>
		<td><%=employeeList.get(index).getPersonalDetails().getName()%></td>
		<td><%=employeeList.get(index).getPersonalDetails().getPhoneNumber()%></td>
		<td><%=employeeList.get(index).getPersonalDetails().getEmailId()%></td>
		<td><%=employeeList.get(index).getPersonalDetails().getDateOfBirth()%></td>
		<%
			List<Address> addressList = new ArrayList<Address>(employeeList.get(index).getPersonalDetails().getAddressSet());
		%>
		<td><%=addressList.get(0).getStreet()%></td>
		<td><%=addressList.get(0).getCity()%></td>
		<td><%=addressList.get(0).getDistrict()%></td>
		<td><%=addressList.get(0).getState()%></td>
		<td><%=addressList.get(0).getPinCode()%></td>
		<td><%=addressList.get(0).getAddressType()%></td>
		<td><%=addressList.get(1).getStreet()%></td>
		<td><%=addressList.get(1).getCity()%></td>
		<td><%=addressList.get(1).getDistrict()%></td>
		<td><%=addressList.get(1).getState()%></td>
		<td><%=addressList.get(1).getPinCode()%></td>
		<td><%=addressList.get(1).getAddressType()%></td>
		</tr>
		<%
			}
		}
		}
		%>
	</table>
</body>
</html>