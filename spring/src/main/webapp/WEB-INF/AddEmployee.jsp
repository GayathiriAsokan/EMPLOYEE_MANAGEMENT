<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE DETAILS</title>
<style>
body {
	background-image: url('/WebContent/view/jsp/Work.jpg');
	background-color: #cccccc;
	height: 500px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.view_only {
	background-color: ghostwhite;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
		function view_only() {
			$("#CompanyName").attr("readonly", true);
			$("#Salary").attr("readonly", true);
			$("#Designation").attr("readonly", true);
			$("#Experience").attr("readonly", true);
			$("#Status").attr("readonly", true);
			$("#Name").attr("readonly", true);
			$("#PhoneNumber").attr("readonly", true);
			$("#EmailId").attr("readonly", true);
			$("#DateOfBirth").attr("readonly", true);
			$("#street1").attr("readonly", true);
			$("#city1").attr("readonly", true);
			$("#district1").attr("readonly", true);
			$("#state1").attr("readonly", true);
			$("#pincode1").attr("readonly", true);
			$("#AddressType1").attr("readonly", true);
			$("#street2").attr("readonly", true);
			$("#city2").attr("readonly", true);
			$("#district2").attr("readonly", true);
			$("#state2").attr("readonly", true);
			$("#pincode2").attr("readonly", true);
			$("#AddressType2").attr("readonly", true);
			$('.non_editable').addClass('view_only');
		}
		$('#same').click(function() {
			if (!($('#same').checked)) {
				$('#street2').val($('#street1').val());
				$('#city2').val($('#city1').val());
				$('#district2').val($('#district1').val());
				$('#state2').val($('#state1').val());
				$('#pincode2').val($('#pincode1').val());
			} else {
				$('#street2').val("");
				$('#city2').val("");
				$('#district2').val("");
				$('#state2').val("");
				$('#pincode2').val("");
			}
		});
		$('#SEARCH').click(function() {
			if ($('#mode').val() == "2") {
				 view_only();
				$("#PhoneNumber").attr("readonly", false);
				$("#EmailId").attr("readonly", false);
			} else if ($('#mode').val() == "3") {
				 view_only();
			     $("#Status").attr("readonly", false);
			} else if ($('#mode').val() == "4") {
				view_only();
			}
			var employeeId = $('#EmployeeId');
			console.log(employeeId);
			$.ajax({
				type : "GET",
				url : "Update/ajax",
				data : employeeId,
				success : function(data) {
					var arrayEmployeeValues = JSON.parse(data);
					var employeeMap = arrayEmployeeValues[0];
					$("#CompanyName").val(employeeMap.companyName);
					$("#Salary").val(employeeMap.salary);
					$("#Designation").val(employeeMap.designation);
					$("#Experience").val(employeeMap.experience);
					$("#Status").val(employeeMap.status);
					$("#Name").val(employeeMap.name);
					$("#PhoneNumber").val(employeeMap.phoneNumber);
					$("#EmailId").val(employeeMap.emailId);
					$("#DateOfBirth").val(employeeMap.dateOfBirth);
					$("#street1").val(employeeMap.currentStreet);
					$("#city1").val(employeeMap.currentCity);
					$("#district1").val(employeeMap.currentDistrict);
					$("#state1").val(employeeMap.currentState);
					$("#pincode1").val(employeeMap.currentPinCode);
					$("#AddressType1").val(employeeMap.currentAddressType);
					$("#street2").val(employeeMap.permanentStreet);
					$("#city2").val(employeeMap.permanentCity);
					$("#district2").val(employeeMap.permanentDistrict);
					$("#state2").val(employeeMap.permanentState);
					$("#pincode2").val(employeeMap.permanentPinCode);
					$("#AddressType2").val(employeeMap.permanentAddressType);
				}
			});
		});
		});
</script>
</head>
<body>
	<p>
		<a href="/"> HOME</a>
	<form id="commentForm" name="commentForm" method="post"
		<% 
	 int mode = Integer.parseInt(request.getParameter("mode"));
	 if (mode == 1) {%>
		action= Insert/submit
		<%} 
        else if (mode == 2)  {%>
		action=Update/submit
		<%}
        else if (mode ==3) { %>
		action=Delete/submit <%} %>>
		<div id="Employee" style="position: absolute; left: 171px;">
			<h1>EMPLOYEE DETAILS</h1>
			<%
			 mode = Integer.parseInt(request.getParameter("mode"));
		if (mode > 1) {
		%>
			<label for="EmployeeId"> EmployeeId: </label><br> <input
				type="number" id="EmployeeId" name="EmployeeId" required> <input
				type="button" id="SEARCH" value="SEARCH">
			<%
			}
		%>
			<br> <br> <label for="CompanyName">CompanyName: </label> <br>
			<input type="text" id="CompanyName" name="CompanyName" size="25"
				class="non_editable" required> <br> <br> <label
				for="Salary">Salary: </label> <br> <input type="number"
				id="Salary" name="Salary" class="non_editable" required> <br>
			<br> <label for="Designation">Designation: </label> <br> <input
				type="text" id="Designation" name="Designation" size="10"
				class="non_editable" required> <br> <br> <label
				for="Experience">Experience: </label> <br> <input type="number"
				id="Experience" name="Experience" class="non_editable" required>
			<br> <br> <label for="Choose A Status">Choose A
				Status: </label> <br> <select name="Status" id="Status">
				<option value="ACTIVE">ACTIVE</option>
				<option value="INACTIVE">INACTIVE</option>
			</select> <br> <br>
			<h2>PERSONAL DETAILS</h2>
			<label for="Name">Name: </label> <br> <input type="text"
				id="Name" name="Name" size="15" class="non_editable" required>
			<br> <br> <label for="PhoneNumber">PhoneNumber: </label> <br>
			<input type="number" id="PhoneNumber" name="PhoneNumber" required>
			<br> <br> <label for="EmailId">EmailId: </label> <br>
			<input type="email" id="EmailId" name="EmailId" size="10" required>
			<br> <br> <label for="DateOfBirth">DateOfBirth: </label> <br>
			<input type="date" id="DateOfBirth" name="DateOfBirth" size="10"
				class="non_editable" required> <br> <br> <br>
			<input type="text" name="mode" id="mode" name="mode"
				value="<%=request.getParameter("mode")%>"
				style="visibility: hidden;"> <br> <br>
		</div>
		<div id="Address" style="position: absolute; left: 756px; top: 90px;">
			<h3>ADDRESS DETAILS</h3>
			<input type="radio" id="CurrentAddress" name="AddressDetails"
				checked="checked"> <label for="CurrentAddress">CurrentAddress</label>
			<br> <input type="radio" id="PermanentAddress"
				name="AddressDetails"> <label for="PermanentAddress">PermanentAddress</label>
			<br>
		</div>
		<div id="CurrentAddressDivision"
			style="position: absolute; left: 741px; top: 215px;">
			<h2>CURRENT ADDRESS</h2>
			<label for="Street">Street: </label><br> <input type="text"
				name="Street" id="street1" size="15" class="non_editable" required>
			<label for="City">City: </label><input type="text" name="City"
				id="city1" size="15" class="non_editable" required> <br>
			<br> <label for="District">District: </label><br> <input
				type="text" name="District" id="district1" size="15"
				class="non_editable" required> <label for="State">State:
			</label> <input type="text" name="State" id="state1" size="15"
				class="non_editable" required> <br> <br> <label
				for="PinCode">PinCode: </label><br> <input type="number"
				name="PinCode" id="pincode1" class="non_editable" required>
			<br> <br> <input type="text" name="AddressType"
				id="AddressType1" value="currentAddress" class="non_editable"
				style="visibility: hidden;"> <br> <br>
		</div>
		<div id="AddressRadio"
			style="position: absolute; left: 741px; top: 470px;" />
		<input type="checkbox" id="same" name="same"> <label
			for="same"> If Permanent Address same select this box. </label>
		</div>
		<div id="PermanentAddressDivision"
			style="position: absolute; left: 741px; top: 500px;">
			<h2>PERMANENT ADDRESS</h2>
			<label for="PermanentStreet">Street </label><br> <input
				type="text" name="PermanentStreet" id="street2" class="non_editable"
				size="15" required> <label for="PermanentCity">City:</label>
			<input type="text" name="PermanentCity" id="city2" size="15"
				class="non_editable" required> <br> <br> <label
				for="PermanentDistrict">District: </label><br> <input
				type="text" name="PermanentDistrict" id="district2" size="15"
				class="non_editable" required> <label for="PermanentState">State:</label>
			<input type="text" name="PermanentState" id="state2" size="15"
				class="non_editable" required> <br> <br> <label
				for="PermanentPinCode">PinCode: </label><br> <input
				type="number" name="PermanentPinCode" id="pincode2"
				class="non_editable" required> <br> <br> <input
				type="text" name="PermanentAddressType" id="AddressType2"
				value="permanentAddress" class="non_editable"
				style="visibility: hidden;">
		</div>
		<%
			mode = Integer.parseInt(request.getParameter("mode"));
		if (mode != 4) {
		%>
		<div id="submit division"
			style="position: absolute; top: 730px; left: 366px; color: darkblue !important; font-size: medium !important;">
			<input type="submit" id="submit" value="ADD EMPLOYEE DETAILS" />
			<%
			}
		%>
		</div>
	</form>
</body>
</html>