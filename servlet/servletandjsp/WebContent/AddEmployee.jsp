<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
var xMLHttpRequest=new xMLHttpRequest();
function sendInfo() {
   xMLHttpRequest.open("Get","/Demo1/ViewEmployee?EmployeeId="+document.getElementById("EmployeeId").value,true);
   xMLHttpRequest.onreadystateChange=processEmployee;
   xMLHttpRequest.send(null);
}
function processEmployee() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status ==200) {
       var JSONTopicObject = eval('(' + XMLHttpRequest.responseText + ')');
    }
}
function addressFunction() {
	if (document.getElementById("CurrentAddress").checked) {
		alert(document.getElementById("CurrentAddressDivision").style.visibility='visible');
		alert(document.getElementById("PermanentAddressDivision").style.visibility='hidden');
	} else if (document.getElementById("PermanentAddress").checked) {
		alert(document.getElementById("PermanentAddressDivision").style.visibility='visible');
		alert(document.getElementById("CurrentAddressDivision").style.visibility='hidden');
	}
}
function update() {
httpRequest = new XMLHttpRequest();

if (!httpRequest) {
console.log('Unable to create XMLHTTP instance');
return false;
}
httpRequest.open('GET', "/Demo1/UpdateEmployee?employeeeId="+ document.getElementById("EmployeeId").value+ "& phoneNumber=" + document.getElementById("PhoneNumber").value +"& emailId=" +document.getElementById("EmailId").value);
httpRequest.send();
httpRequest.onreadystatechange = processEmployee() {
if (httpRequest.readyState === XMLHttpRequest.DONE) {
if (httpRequest.status === 200) {
alert("UPDATED SUCCESSFULLY");
}else {
console.log('Something went wrong..!!');
}
} 
}
}
function addressValuesFunction() {
 if (document.getElementById( "same").checked) { 
      document.getElementById("street2").value =  document.getElementById("street1").value; 
      document.getElementById("city2").value =  document.getElementById("city1").value; 
      document.getElementById("district2").value =  document.getElementById("district1").value; 
      document.getElementById("state2").value =  document.getElementById("state1").value; 
      document.getElementById("pincode2").value = document.getElementById("pincode1").value; 
  } else { 
      document.getElementById("street2").value = "";
      document.getElementById("city2").value = "";
      document.getElementById("district2").value = ""; 
      document.getElementById("state2").value = "";  
      document.getElementById("pincode2").value =  "";
  } 
}
</script>
</head>
<body>
Hello User
<h1>INSERT EMPLOYEE DETAILS</h1>
<form action="/yy">
<label for="CompanyName">CompanyName:
</label><br>
<input type="text" name="Name" size="25" required>
<br> <br>
<label for="Salary">Salary:
</label><br>
<input type="number" name="Salary" required>
<br> <br>
<label for="Designation">Designation:
</label><br>
<input type="text" name="Designation" size="10" required>
<br> <br>
<label for="Experience">Experience:
</label><br>
<input type="number" name="Experience" required>
<br> <br>
<label for="Status">Status:
</label><br>
<input type="text" name="Status" size="10" required>
<br> <br>
<h2>PERSONAL DETAILS</h2>
<label for="Name">Name:
</label><br>
<input type="text" name="Name" size="15" required>
<br> <br>
<label for="PhoneNumber">PhoneNumber:
</label><br>
<input type="number" name="PhoneNumber" required>
<br> <br>
<label for="EmailId">EmailId:
</label><br>
<input type="email" name="EmailId" size="10" required>
<br> <br>
<label for="DateOfBirth">DateOfBirth:
</label><br>
<input type="date" name="DateOfBirth" size="10" required>
<br> <br>
<h3>ADDRESS DETAILS</h3>
<input type="radio" id ="CurrentAddress" name="AddressDetails" checked="checked" onchange="addressFunction()">
<label for ="CurrentAddress">CurrentAddress</label><br>
<input type="radio" id ="PermanentAddress" name="AddressDetails" onchange="addressFunction()">
<label for ="PermanentAddress">PermanentAddress</label><br>
<div id="CurrentAddressDivision">
<h2>CURRENT ADDRESS</h2>
<label for="Street">Street:
</label><br>
<input type="text" name="Street" id="street1" size="15" required>
<br> <br>
<label for="City">City:
</label><br>
<input type="text" name="City" id="city1" size="15" required>
<br> <br>
<label for="District">District:
</label><br>
<input type="text" name="District" id="district1" size="15" required>
<br> <br>
<label for="State">State:
</label><br>
<input type="text" name="State" id="state1" size="15" required>
<br> <br>
<label for="PinCode">PinCode:
</label><br>
<input type="number" name="PinCode" id="pincode1" required>
<br> <br>
</div>
  <input type="checkbox" id="same" name="same" onchange="addressValuesFunction()" /> 
<label for="same"> 
              If Permanent Address same select this box. 
          </label>  
<div id="PermanentAddressDivision" style="visibility: hidden">
<h2>PERMANENT ADDRESS</h2>
<label for="PermanentStreet">Street:
</label><br>
<input type="text" name="Street" id="street2"size="15" required>
<br> <br>
<label for="PermanentCity">City:
</label><br>
<input type="text" name="City" id="city2" size="15" required>
<br> <br>
<label for="PermanentDistrict">District:
</label><br>
<input type="text" name="District" id="district2" size="15" required>
<br> <br>
<label for="PermanentState">State:
</label><br>
<input type="text" name="State" id="state2" size="15" required>
<br> <br>
<label for="PermanentPinCode">PinCode:
</label><br>
<input type="number" name="PinCode" id="pincode2" required>
<br> <br>
</div>
<input type="submit" value="submit">
</body>
</html>