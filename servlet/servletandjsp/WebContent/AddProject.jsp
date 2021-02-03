<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT DETAILS</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
$(function () {
	$('#submit').click(function () {
		var postData = $('#commentForm').serializeArray();
		console.log(postData);
		$.ajax({
			type:"GET",
			url:"ProjectSubmission",
			data: postData,
			success: function (response) {
	                alert(response);
	            }
		});
		});
	$('#SEARCH').click(function () {
		var ProjectId = $('#ProjectId');
		console.log(ProjectId);
		$.ajax({
			type:"GET",
			url:"ViewProject",
			data: ProjectId,
			success: function (response) {
				var arrayProjectValues = response;
				var projectMap = arrayProjectValues[0];
				$("#ProjectName").val(projectMap.ProjectName);
				$("#ProjectManager").val(projectMap.ProjectManager);
				$("#Technology").val(projectMap.Technology);
				$("#ProjectType").val(projectMap.ProjectType);
				$("#StartDate").val(projectMap.StartDate);
				$("#EndDate").val(projectMap.EndDate);
				$("#ActualEndDate").val(projectMap.ActualEndDate);
			}
		});
	});
});
</script>
</head>
<body>
 <form id="commentForm" name="commentForm" method="get" action="#">
	<h1>PROJECT DETAILS</h1>
	  <% int mode = Integer.parseInt(request.getParameter("mode")); 
          if (mode > 1) {%>
	     <label for="ProjectId">
	     ProjectId:
	     </label><br>
		  <input type="number" id="ProjectId" name="ProjectId" required>
		  <input type="button" id ="SEARCH" value ="SEARCH"> 
		  <% } %>
		  <br>
		  <br>
	<label for="ProjectName">ProjectName: </label>
	<br>
	<input type="text" id="ProjectName" name="ProjectName" size="25" required>
	<br>
	<br>
	<label for="ProjectManager">ProjectManager: </label>
	<br>
	<input type="text" id="ProjectManager" name="ProjectManager" required>
	<br>
	<br>
	<label for="Choose A Technology">Choose A Technology: </label>
	<br>
	<select name = "Technology" id ="Technology">
	<option value="JAVA"> JAVA</option>
	<option value="PYTHON"> PYTHON</option>
	<option value=".NET"> .NET</option>
	<option value="NODEJS"> NODEJS</option>
	</select>
	<br>
	<br>
	<label for="ProjectType">ProjectType: </label>
		<br>
	<input type="text" id="ProjectType" name="ProjectType" size="10" required>
	<br>
	<br>
	<label for="StartDate">StartDate: </label>
	<br>
	<input type="date" id="StartDate" name="StartDate" size="10" required>
	<br>
	<br>
	<label for="EndDate">EndDate: </label>
	<br>
	<input type="date" id="EndDate" name="EndDate" size="10" required>
	<br>
	<br>
	<br> <input type="text" name="mode" id="mode" name="mode"
			value="<%= request.getParameter("mode")%>" style="visibility: hidden;"> <br>
		<br>
	<label for="ActualEndDate">ActualEndDate: </label>
	<br>
	<input type="date" id="ActualEndDate" name="ActualEndDate" size="10" required>
	<br>
	<br>
	<% mode = Integer.parseInt(request.getParameter("mode")); 
          if (mode != 3 && mode != 4) {%>
	<input type="submit" id="submit" value="ADDPROJECT"/>
	<%} %>
	</form>
</body>
</html>