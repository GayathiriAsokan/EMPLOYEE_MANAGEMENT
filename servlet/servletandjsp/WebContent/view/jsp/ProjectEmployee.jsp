<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ideas2it.employee.model.Employee"%>
<%@ page import="com.ideas2it.employee.service.EmployeeServiceImpl"%>
<%@ page import="com.ideas2it.project.service.ProjectServiceImpl"%>
<%@ page import="com.ideas2it.project.model.Project"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE PROJECT MANAGEMENT</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#submit').click(function() {
			var postData = $('#commentForm').serializeArray();
			console.log(postData);
			$.ajax({
				type : "GET",
				url : "ProjectSubmission",
				data : postData,
				success : function(response) {
					alert(response);
				}
			});
		});
	});
</script>
</head>
<body>
<p><a href="/Demo1/Index.jsp" > HOME</a>
	<form id="commentForm" name="commentForm" method="get" action="#">
		<label for="EmployeeProject"> Choose A Project</label> 
		<select name="Project" id="Project">
			<%
		ProjectServiceImpl projectService = new ProjectServiceImpl();
		List<Project> projectList = projectService.viewProject();
		for (int index = 0; index < projectList.size(); index++) {
			Project project = projectList.get(index);
		%>
			<option value=<%=project.getProjectId()%>>
				<%=project.getProjectId()%> :
				<%=project.getProjectName() %>
			</option>
			<%} %>
		</select> <br> <br> <label for="EmployeeProject"> Choose A Employee </label> 
		<select name="Employee" id="Employee"  multiple>
			<% EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
              List <Employee> employeeList = employeeService.getAllEmployee();
              for (int index = 0 ; index < employeeList.size() ; index ++) {
                  Employee employee = employeeList.get(index);%>
			<option value=<%=employee.getEmployeeId()%>>
				<%=employee.getEmployeeId()%> :
				<%= employee.getPersonalDetails().getName() %></option>
			<%} %>
		</select> <input type="text" name="mode" id="mode" name="mode"
			value="<%=request.getParameter("mode")%>" style="visibility: hidden;">
		<br> <br> <input type="submit" id="submit"
			value="AddEmployeeProject" />
	</form>
</body>
</html>