<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "java.util.List" %>
    <%@ page import = "com.ideas2it.employee.model.Employee" %>
    <%@ page import = "com.ideas2it.employee.service.Impl.EmployeeServiceImpl" %>
    <%@ page import = "com.ideas2it.employee.model.Address" %>
     <%@ page import = "com.ideas2it.project.model.Project" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th,td {
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
<input type="button" id="display" value="Display Employees with their projects"/>
<input type="button" id="view" value="Display All Employee"/>
<h1>EMPLOYEE MANAGEMENT DETAILS</h1>
<table>
<tr>
<th>EmployeeID</th>
<th>CompanyName</th>
<th>Designation</th>
<th>Salary</th>
<th>Experience</th>
<th class="display view ">Status</th>
<th>EmployeeName</th>
<th>PhoneNumber</th>
<th>EmailId</th>
<th>DateOfBirth</th>
<th class="display view ">Street</th>
<th class="display view">City</th>
<th class="display view">District</th>
<th class="display view">State</th>
<th class="display view">PinCode</th>
<th class="display view">AddressType</th>
<th class="display view">PermanentStreet</th>
<th class="display view">PermanentCity</th>
<th class="display view">PermanentDistrict</th>
<th class="display view">PermanentState</th>
<th class="display view">PermanentPinCode</th>
<th class="display view">PermanentAddressType</th>
<th class="display view">ProjectID</th>
<th class="display view">ProjectName</th>
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
    <td class="display view "> <%= employee.getStatus() %></td>
	<td> <%= employee.getPersonalDetails().getName() %></td>
	<td> <%= employee.getPersonalDetails().getPhoneNumber() %></td>
	<td> <%= employee.getPersonalDetails().getEmailId() %></td>
	<td> <%= employee.getPersonalDetails().getDateOfBirth() %></td>
	<% List <Address> addressList = new ArrayList <Address> (employee.getPersonalDetails().getAddressSet());%> 
	<td class="display view"> <%= addressList.get(0).getStreet()%> </td>
	<td class="display view"> <%= addressList.get(0).getCity()%> </td>
	<td class="display view"> <%= addressList.get(0).getDistrict()%> </td>
	<td class="display view"> <%= addressList.get(0).getState()%> </td>
	<td class="display view"> <%= addressList.get(0).getPinCode()%> </td>
	<td class="display view"> <%= addressList.get(0).getAddressType()%> </td>
	<td class="display view"> <%= addressList.get(1).getStreet()%> </td>
	<td class="display view"> <%= addressList.get(1).getCity()%> </td>
	<td class="display view"> <%= addressList.get(1).getDistrict()%> </td>
	<td class="display view"> <%= addressList.get(1).getState()%> </td>
	<td class="display view"> <%= addressList.get(1).getPinCode()%> </td>
	<td class="display view"> <%= addressList.get(1).getAddressType()%> </td>
	<% List <Project> projectList = new ArrayList <Project> (employee.getProjectSet()); 
	for (int projectIndex = 0 ; projectIndex < projectList.size(); projectIndex ++) {
	 if(projectIndex > 0 ) { %>
<td class="display view"> <%= employee.getEmployeeId() %></td>
	<td class="display view"> <%= employee.getCompanyName() %></td>
	<td class="display view"> <%= employee.getDesignation() %></td>
    <td class="display view"> <%= employee.getSalary() %></td>
    <td class="display view"> <%= employee.getExperience() %></td>
    <td class="display view"> <%= employee.getStatus() %></td>
	<td class="display view"> <%= employee.getPersonalDetails().getName() %></td>
	<td class="display view"> <%= employee.getPersonalDetails().getPhoneNumber() %></td>
	<td class="display view"> <%= employee.getPersonalDetails().getEmailId() %></td>
	<td class="display view"> <%= employee.getPersonalDetails().getDateOfBirth() %></td>
	<td class="display view"> <%= addressList.get(0).getStreet()%> </td>
	<td class="display view"> <%= addressList.get(0).getCity()%> </td>
	<td class="display view"> <%= addressList.get(0).getDistrict()%> </td>
	<td class="display view"> <%= addressList.get(0).getState()%> </td>
	<td class="display view"> <%= addressList.get(0).getPinCode()%> </td>
	<td class="display view"> <%= addressList.get(0).getAddressType()%> </td>
	<td class="display view"> <%= addressList.get(1).getStreet()%> </td>
	<td class="display view"> <%= addressList.get(1).getCity()%> </td>
	<td class="display view"> <%= addressList.get(1).getDistrict()%> </td>
	<td class="display view"> <%= addressList.get(1).getState()%> </td>
	<td class="display view"> <%= addressList.get(1).getPinCode()%> </td>
	<td class="display view"> <%= addressList.get(1).getAddressType()%> </td>
    <td class="display view"> <%= projectList.get(projectIndex).getProjectId() %> </td>
	<td class="display view"><%= projectList.get(projectIndex).getProjectName() %> </td>
	</tr>
<% }
 else{ %>
    <td class="display view"> <%= projectList.get(projectIndex).getProjectId() %> </td>
	<td class="display view"><%= projectList.get(projectIndex).getProjectName() %> </td>
	</tr>
	<%}} }%>
	<%-- <% } } }%> --%>
</table>
</body>
</html>