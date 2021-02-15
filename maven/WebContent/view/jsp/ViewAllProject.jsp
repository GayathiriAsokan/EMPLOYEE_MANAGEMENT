<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ideas2it.employee.model.Employee"%>
<%@ page import="com.ideas2it.project.service.Impl.ProjectServiceImpl"%>
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
.display {
display:none;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#display').click(function() {
				$('.display').removeClass("display");
			});
		$('#view').click(function() {
			$('.view').addClass("display");
		});
		});
	</script>
<meta charset="UTF-8">
<title>EMPLOYEE MANAGEMENT DETAILS</title>
</head>
<body>
<p><a href="/Demo1/Index.jsp"> HOME</a>
<input type="button" id="display" value="Display All Project with Employee Details"/>
<input type="button" id="view" value="Display All Project"/>
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
			<th class="display view ">EmployeeID</th>
			<th class="display view ">CompanyName</th>
			<th class="display view ">Designation</th>
			<th class="display view ">Salary</th>
			<th class="display view ">Experience</th>
			<th class="display view ">Status</th>
			<th class="display view ">EmployeeName</th>
			<th class="display view ">PhoneNumber</th>
			<th class="display view ">EmailId</th>
			<th class="display view ">DateOfBirth</th>
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
		<tr>
			<td class="display view "><%=project.getProjectId()%></td>
			<td class="display view "><%=project.getProjectName()%></td>
			<td class="display view "><%=project.getProjectManager()%></td>
			<td class="display view "><%=project.getTechnology()%></td>
			<td class="display view "><%=project.getProjectType()%></td>
			<td class="display view "><%=project.getStartDate()%></td>
			<td class="display view "><%=project.getEndDate()%></td>
			<td class="display view "><%=project.getActualEndDate()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getEmployeeId()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getCompanyName()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getDesignation()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getSalary()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getExperience()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getStatus()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getName()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getPhoneNumber()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getEmailId()%></td>
			<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getDateOfBirth()%></td>
		</tr>
		<%}
			else {  %>
		<td class="display view "><%=employeeList.get(employeeIndex).getEmployeeId()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getCompanyName()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getDesignation()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getSalary()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getExperience()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getStatus()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getName()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getPhoneNumber()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getEmailId()%></td>
		<td class="display view "><%=employeeList.get(employeeIndex).getPersonalDetails().getDateOfBirth()%></td>
		</tr>
		<%
			}	}
			}
		%>
	</table>
</body>
</html>