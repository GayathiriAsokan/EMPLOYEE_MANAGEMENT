<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "java.util.List" %>
    <%@ page import = "main.java.com.ideas2it.employee.model.Employee" %>
    <%@ page import = "main.java.com.ideas2it.employee.service.Impl.EmployeeServiceImpl" %>
    <%@ page import="main.java.com.ideas2it.project.service.Impl.ProjectServiceImpl"%>
    <%@ page import="main.java.com.ideas2it.project.model.Project"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE PROJECT MANAGEMENT</title>
</head>
	<body>
	<p><a href="/Demo1/Index.jsp"> HOME</a>
<form id="commentForm" name="commentForm" method="post" action="/EmployeeController/AddProject/submit">
<label for="EmployeeProject"> Choose A Employee </label>
<select name="Employee" id ="Employee">
<% EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
List <Employee> employeeList = employeeService.getAllEmployee();
for (int index = 0 ; index < employeeList.size() ; index ++) {
        Employee employee = employeeList.get(index);%>
      <option value = <%=employee.getEmployeeId()%>> <%=employee.getEmployeeId()%> : <%= employee.getPersonalDetails().getName() %></option>
    <%} %>
    </select>
    <br>
   <br> 
    <label for="EmployeeProject"> Choose A Project</label>
    <select  name="Project" id ="Project" multiple>  
    <%
		ProjectServiceImpl projectService = new ProjectServiceImpl();
		List<Project> projectList = projectService.viewProject();
		for (int index = 0; index < projectList.size(); index++) {
			Project project = projectList.get(index);
		%>
        <option value = <%=project.getProjectId()%> > <%=project.getProjectId()%> : <%=project.getProjectName() %> </option>
        <%} %>
      </select>  
      <input type="text" name="mode" id="mode" name="mode"
			value="<%=request.getParameter("mode")%>"
			style="visibility: hidden;"> <br> <br>
      <input type="submit" id="submit" value="AddEmployeeProject"/>
      </form>
</body>
</html>