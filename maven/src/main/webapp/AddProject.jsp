<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROJECT DETAILS</title>
<style>
.view_only{
background-color: ghostwhite;
}
body {
background-image: url("Work.jpg"); 
  background-color: #cccccc; 
  height: 500px; 
  background-position: center;
  background-repeat: no-repeat; 
  background-size: cover; 
}
</style>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
$(function () {
	function view_only() {
		$("#ProjectName").attr("readonly", true);
		$("#ProjectManager").attr("readonly", true);
		$("#Technology").attr("readonly", true);
		$("#ProjectType").attr("readonly", true);
		$("#StartDate").attr("readonly", true);
		$("#EndDate").attr("readonly", true);
	}
	$('#SEARCH').click(function () {
		if ($('#mode').val() == "2") {
			 view_only();
				$("#ActualEndDate").attr("readonly", false);
		} else if ($('#mode').val() == "4") {
			view_only();
		}
		var ProjectId = $('#ProjectId');
		console.log(ProjectId);
		$.ajax({
			type:"GET",
			url:"Update/ajax",
			data: ProjectId,
			success: function (response) {
				if (response.status == null) {
				var arrayProjectValues = response;
				var projectMap = arrayProjectValues[0];
				$("#ProjectName").val(projectMap.ProjectName);
				$("#ProjectManager").val(projectMap.ProjectManager);
				$("#Technology").val(projectMap.Technology);
				$("#ProjectType").val(projectMap.ProjectType);
				$("#StartDate").val(projectMap.StartDate);
				$("#EndDate").val(projectMap.EndDate);
				$("#ActualEndDate").val(projectMap.ActualEndDate);
				} else {
					var errorStatus = response;
					alert(errorStatus.status);
				}
			}
		});
	});
});
</script>
</head>
<body>
<p><a href="/Index.jsp"> HOME</a>
 <form id="commentForm" name="commentForm" method="post" 
 <% 
	 int mode = Integer.parseInt(request.getParameter("mode"));
	 if (mode == 1) {%>
	 action= /ProjectController/Insert/submit
	 <%} 
        else if (mode == 2)  {%>
		 action= /ProjectController/Update/submit
		 <%}
        else if (mode == 6) { %>
        action= /ProjectController/Delete/submit
        <%} %>
        >
 <div id="project" style="position: absolute;
    left: 419px;">
	<h1>PROJECT DETAILS</h1>
	  <%  mode = Integer.parseInt(request.getParameter("mode")); 
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
	<label for="ProjectType">ProjectType: </label>
		<br>
	<input type="text" id="ProjectType" name="ProjectType" size="10" required>
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
	<label for="ActualEndDate">ActualEndDate: </label>
	<br>
	<input type="date" id="ActualEndDate" name="ActualEndDate" size="10" required>
	<br>
     <br> <br> <label for="Choose A ProjectStatus">Choose
				A ProjectStatus: </label> <br> <select name="ProjectStatus" id="ProjectStatus" >
				<option value="PROJECT NOT YET COMPLETED">PROJECT NOT YET COMPLETED</option>
				<option value="PROJECT IN PROGRSS">PROJECT IN PROGRSS</option>
				<option value="PROJECT COMPLETED">PROJECT COMPLETED</option>
			</select>
	<input type="text" name="mode" id="mode" name="mode"
			value="<%= request.getParameter("mode")%>" style="visibility: hidden;"> <br>
		<br>
	<% mode = Integer.parseInt(request.getParameter("mode")); 
          if (mode != 3 && mode != 4) {%>
	<input type="submit" id="submit" value="ADDPROJECT"/>
	<%} %>
	</div>
	</form>
</body>
</html>