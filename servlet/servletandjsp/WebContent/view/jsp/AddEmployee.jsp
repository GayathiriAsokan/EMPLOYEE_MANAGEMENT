<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE DETAILS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
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
			var employeeId = $('#EmployeeId');
			console.log(employeeId);
			$.ajax({
				type : "GET",
				url : "ViewEmployee",
				data : employeeId,
				success : function(response) {
					var arrayEmployeeValues = response;
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
		$('#submit').click(function() {
			var postData = $('#commentForm').serializeArray();
			console.log(postData);
			$.ajax({
				type : "GET",
				url : "EmployeeSubmission",
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
	<form id="commentForm" name="commentForm" method="get" action="#">
		<h1>EMPLOYEE DETAILS</h1>
		<%
			int mode = Integer.parseInt(request.getParameter("mode"));
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
			required> <br> <br> <label for="Salary">Salary:
		</label> <br> <input type="number" id="Salary" name="Salary" required>
		<br> <br> <label for="Designation">Designation: </label> <br>
		<input type="text" id="Designation" name="Designation" size="10"
			required> <br> <br> <label for="Experience">Experience:
		</label> <br> <input type="number" id="Experience" name="Experience"
			required> <br> <br> 
			<label for="Choose A Status">Choose A Status: </label>
	<br>
	<select name = "Status" id ="Status" >
	<option value="ACTIVE"> ACTIVE</option>
	<option value="INACTIVE"> INACTIVE</option>
	</select>
			<br> <br>
		<h2>PERSONAL DETAILS</h2>
		<label for="Name">Name: </label> <br> <input type="text"
			id="Name" name="Name" size="15" required> <br> <br>
		<label for="PhoneNumber">PhoneNumber: </label> <br> <input
			type="number" id="PhoneNumber" name="PhoneNumber" required> <br>
		<br> <label for="EmailId">EmailId: </label> <br> <input
			type="email" id="EmailId" name="EmailId" size="10" required>
		<br> <br> <label for="DateOfBirth">DateOfBirth: </label> <br>
		<input type="date" id="DateOfBirth" name="DateOfBirth" size="10"
			required> <br> <br> <br> <input type="text"
			name="mode" id="mode" name="mode"
			value="<%=request.getParameter("mode")%>"
			style="visibility: hidden;"> <br> <br>
		<h3>ADDRESS DETAILS</h3>
		<input type="radio" id="CurrentAddress" name="AddressDetails"
			checked="checked"> <label for="CurrentAddress">CurrentAddress</label>
		<br> <input type="radio" id="PermanentAddress"
			name="AddressDetails"> <label for="PermanentAddress">PermanentAddress</label>
		<br>
		<div id="CurrentAddressDivision">
			<h2>CURRENT ADDRESS</h2>
			<label for="Street">Street: </label><br> <input type="text"
				name="Street" id="street1" size="15" required> <br> <br>
			<label for="City">City: </label><br> <input type="text"
				name="City" id="city1" size="15" required> <br> <br>
			<label for="District">District: </label><br> <input type="text"
				name="District" id="district1" size="15" required> <br>
			<br> <label for="State">State: </label><br> <input
				type="text" name="State" id="state1" size="15" required> <br>
			<br> <label for="PinCode">PinCode: </label><br> <input
				type="number" name="PinCode" id="pincode1" required> <br>
			<br> <input type="text" name="AddressType" id="AddressType1"
				value="currentAddress" style="visibility: hidden;"> <br>
			<br>
		</div>
		<input type="checkbox" id="same" name="same" /> <label for="same">
			If Permanent Address same select this box. </label>
		<div id="PermanentAddressDivision">
			<h2>PERMANENT ADDRESS</h2>
			<label for="PermanentStreet">Street </label><br> <input
				type="text" name="PermanentStreet" id="street2" size="15" required>
			<br> <br> <label for="PermanentCity">City:</label><br>
			<input type="text" name="PermanentCity" id="city2" size="15" required>
			<br> <br> <label for="PermanentDistrict">District:
			</label><br> <input type="text" name="PermanentDistrict" id="district2"
				size="15" required> <br> <br> <label
				for="PermanentState">State:</label><br> <input type="text"
				name="PermanentState" id="state2" size="15" required> <br>
			<br> <label for="PermanentPinCode">PinCode: </label><br> <input
				type="number" name="PermanentPinCode" id="pincode2" required>
			<br> <br> <input type="text" name="PermanentAddressType"
				id="AddressType2" value="permanentAddress"
				style="visibility: hidden;">
		</div>
		<%
			mode = Integer.parseInt(request.getParameter("mode"));
		if (mode != 4) {
		%>
		<input type="submit" id="submit" value="AddEmployee" />
		<%
			}
		%>
	</form>
</body>
</html>