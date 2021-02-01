<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INSERT EMPLOYEE DETAILS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function () {
		alert("gf");
		$('#same').click(function () {
			alert("ids")
			if (!($('#same').checked)) {
				alert("fgjg");
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
		$('#submit').click(function () {
			var postData = $('#commentForm').serializeArray();
			var formURL=$('#commentForm').attr("action");
			console.log(postData);
			$.ajax({
				type:"POST",
				url:"EmployeeSubmission",
				data: postData,
				success: function (response) {
		                alert(response);
		            }
			});
			});
	});
</script>
</head>
<body>
    <form id="commentForm" name="commentForm" method="post">
	<h1>INSERT EMPLOYEE DETAILS</h1>
	<label for="CompanyName">CompanyName: </label>
	<br>
	<input type="text" id="CompanyName" name="CompanyName" size="25" required>
	<br>
	<br>
	<label for="Salary">Salary: </label>
	<br>
	<input type="number" id="Salary" name="Salary" required>
	<br>
	<br>
	<label for="Designation">Designation: </label>
	<br>
	<input type="text" id="Designation" name="Designation" size="10" required>
	<br>
	<br>
	<label for="Experience">Experience: </label>
	<br>
	<input type="number" id="Experience" name="Experience" required>
	<br>
	<br>
	<label for="Status">Status: </label>
	<br>
	<input type="text" id="Status" name="Status" size="10" required>
	<br>
	<br>
	<h2>PERSONAL DETAILS</h2>
	<label for="Name">Name: </label>
	<br>
	<input type="text" id="Name" name="Name" size="15" required>
	<br>
	<br>
	<label for="PhoneNumber">PhoneNumber: </label>
	<br>
	<input type="number" id="PhoneNumber" name="PhoneNumber" required>
	<br>
	<br>
	<label for="EmailId">EmailId: </label>
	<br>
	<input type="email" id="EmailId" name="EmailId" size="10" required>
	<br>
	<br>
	<label for="DateOfBirth">DateOfBirth: </label>
	<br>
	<input type="date" id="DateOfBirth" name="DateOfBirth" size="10" required>
	<br>
	<br>
	<br> <input type="text" name="mode" id="mode" name="mode"
			value="<%= request.getParameter("mode")%>" style="visibility: hidden;"> <br>
		<br>
	<h3>ADDRESS DETAILS</h3>
	<input type="radio" id="CurrentAddress" name="AddressDetails"
		checked="checked">
	<label for="CurrentAddress">CurrentAddress</label>
	<br>
	<input type="radio" id="PermanentAddress" name="AddressDetails">
	<label for="PermanentAddress">PermanentAddress</label>
	<br>
	<div id="CurrentAddressDivision">
		<h2>CURRENT ADDRESS</h2>
		<label for="Street">Street: </label><br> <input type="text"
			name="Street" id="street1" size="15" required> <br> <br>
		<label for="City">City: </label><br> <input type="text"
			name="City" id="city1" size="15" required> <br> <br>
		<label for="District">District:  </label><br> 
		<input type="text" name="District" id="district1" size="15" required> <br>
		<br> <label for="State">State: </label><br> <input
			type="text" name="State" id="state1" size="15" required> <br>
		<br> <label for="PinCode">PinCode: </label><br> <input
			type="number" name="PinCode" id="pincode1" required> <br>
		<br> <input type="text" name="AddressType" id="AddressType1"
			value="currentAddress" style="visibility: hidden;"> <br>
		<br>
	</div>
	<input type="checkbox" id="same" name="same" />
	<label for="same"> If Permanent Address same select this box. </label>
	<div id="PermanentAddressDivision">
		<h2>PERMANENT ADDRESS</h2>
		<label for="PermanentStreet">Street </label><br> <input
			type="text" name="PermanentStreet" id="street2" size="15" required>
		<br> <br> <label for="PermanentCity">City:</label><br>
		<input type="text" name="PermanentCity" id="city2" size="15" required>
		<br> <br> <label for="PermanentDistrict">District: </label><br>
		<input type="text" name="PermanentDistrict" id="district2" size="15"
			required> <br> <br> <label for="PermanentState">State:</label><br>
		<input type="text" name="PermanentState" id="state2" size="15"
			required> <br> <br> <label for="PermanentPinCode">PinCode:
		</label><br> <input type="number" name="PermanentPinCode" id="pincode2"
			required> <br> <br> <input type="text"
			name="PermanentAddressType" id="AddressType2" value="permanentAddress"
			style="visibility: hidden;">
	</div>
	<input type="submit" id="submit" value="AddEmployee" />
	</form>
</body>
</html>