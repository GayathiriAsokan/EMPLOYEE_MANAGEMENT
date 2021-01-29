package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

/**
 * 
 * @author GAYATHIRI
 *
 */
public class AddEmployee extends HttpServlet {

	/**
	 * 
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter(); 
		out.println("<html>\n"
				+ "<head>\n"
				+ "<title>INSERT EMPLOYEE DETAILS</title>\n"
				+ "<script>\n");
		out.println("function sendInfo() {\n"
				+ "httpRequest = new XMLHttpRequest();\n"
				+ "if (!httpRequest) {\n"
				+ "console.log('Unable to create XMLHTTP instance');\n"
				+ "return false;\n"
				+ "}\n"
				+ "httpRequest.open('GET', \"/Demo1/ViewEmployee?EmployeeId=\"+document.getElementById(\"EmployeeId\").value);\n"
				+ "httpRequest.responseType = 'json';\n"
				+ "httpRequest.send();\n"
				+ "httpRequest.onreadystatechange = function() {\n"
				+ "if (httpRequest.readyState === XMLHttpRequest.DONE) {\n"
				+ "if (httpRequest.status === 200) {\n"
				+ "var arrayEmployeeValues = httpRequest.response;\n"
				+ "var employeeMap = arrayEmployeeValues[0];\n"
				+ "document.getElementById(\"CompanyName\").value=employeeMap.companyName;\n"
				+ "document.getElementById(\"Salary\").value=employeeMap.salary;\n"
				+ "document.getElementById(\"Designation\").value=employeeMap.designation;\n"
				+ "document.getElementById(\"Experience\").value=employeeMap.experience;\n"
				+ "document.getElementById(\"Status\").value=employeeMap.status;\n"
				+ "document.getElementById(\"Name\").value=employeeMap.name;\n"
				+ "document.getElementById(\"PhoneNumber\").value=employeeMap.phoneNumber;\n"
				+ "document.getElementById(\"EmailId\").value=employeeMap.emailId;\n"
				+ "document.getElementById(\"DateOfBirth\").value=employeeMap.dateOfBirth;\n"
				+ "document.getElementById(\"street1\").value=employeeMap.currentStreet;\n"
				+ "document.getElementById(\"city1\").value=employeeMap.currentCity;\n"
				+ "document.getElementById(\"district1\").value=employeeMap.currentDistrict;\n"
				+ "document.getElementById(\"state1\").value=employeeMap.currentState;\n"
				+ "document.getElementById(\"pincode1\").value=employeeMap.currentPinCode;\n"
				+ "document.getElementById(\"AddressType1\").value=employeeMap.currentAddressType;\n"
				+ "document.getElementById(\"street2\").value=employeeMap.permanentStreet;\n"
				+ "document.getElementById(\"city2\").value=employeeMap.permanentCity;\n"
				+ "document.getElementById(\"district2\").value=employeeMap.permanentDistrict;\n"
				+ "document.getElementById(\"state2\").value=employeeMap.permanentState;\n"
				+ "document.getElementById(\"pincode2\").value=employeeMap.permanentPinCode;\n"
				+ "document.getElementById(\"AddressType2\").value=employeeMap.permanentAddressType;"
				+ "}else {\n"
				+ "console.log('Something went wrong..!!');\n"
				+ "}\n"
				+ "} \n"
				+ "} \n"
				+ "} \n"
				+ "function addressValuesFunction() {\n"
				+ " if (document.getElementById( \"same\").checked) { \n"
				+ "      document.getElementById(\"street2\").value =  document.getElementById(\"street1\").value; \n"
				+ "      document.getElementById(\"city2\").value =  document.getElementById(\"city1\").value; \n"
				+ "      document.getElementById(\"district2\").value =  document.getElementById(\"district1\").value; \n"
				+ "      document.getElementById(\"state2\").value =  document.getElementById(\"state1\").value; \n"
				+ "      document.getElementById(\"pincode2\").value = document.getElementById(\"pincode1\").value; \n"
				+ " } else { \n"
				+ "      document.getElementById(\"street2\").value = \"\";\n"
				+ "      document.getElementById(\"city2\").value = \"\";\n"
				+ "      document.getElementById(\"district2\").value = \"\"; \n"
				+ "      document.getElementById(\"state2\").value = \"\";  \n"
				+ "      document.getElementById(\"pincode2\").value =  \"\";\n"
				+ "  } \n"
				+ "}\n");
		out.println("function update() {\n"
				+ "httpRequest = new XMLHttpRequest();\n"
				+ "var employeeId = document.getElementById(\"EmployeeId\").value;\n"
				+ "var phoneNumber = document.getElementById(\"PhoneNumber\").value;\n"
				+ "var emailId =  document.getElementById(\"EmailId\").value;\n"
				+ "if (!httpRequest) {\n"
				+ "console.log('Unable to create XMLHTTP instance');\n"
				+ "return false;\n"
				+ "}\n"
				+ "httpRequest.open('GET',\'/Demo1/UpdateEmployee?employeeId=\'+employeeId+\'&phoneNumber=\'+phoneNumber+\'&emailId=\'+emailId);\n"
				+ "httpRequest.send();\n"
				+ "httpRequest.onreadystatechange = function() {\n"
				+ "if (httpRequest.readyState === XMLHttpRequest.DONE) {\n"
				+ "if (httpRequest.status === 200) {\n"
				+ "var status = httpRequest.response;\n"
				+ "alert(status);\n"
				+ "}else {\n"
				+ "console.log('Something went wrong..!!');\n"
				+ "}\n"
				+ "} \n"
				+ "}\n"
				+ "}\n"
				+ "function Delete() {\n" 
				+ "httpRequest = new XMLHttpRequest();\n" 
				+ "var employeeId = document.getElementById(\"EmployeeId\").value;\n" 
				+ "if (!httpRequest) {\n"
				+ "console.log('Unable to create XMLHTTP instance');\n" 
				+ "return false;\n" 
				+  "}\n" 
				+ "httpRequest.open('GET',\'/Demo1/DeleteEmployee?employeeId=\'+employeeId);\n"
				+ "httpRequest.send();\n" 
				+ "httpRequest.onreadystatechange = function() {\n"
				+ "if (httpRequest.readyState === XMLHttpRequest.DONE) {\n" 
				+  "if (httpRequest.status === 200) {\n" 
				+  "var status = httpRequest.response;\n" 
				+ "alert(status);\n" 
				+ "}else {\n" 
				+  "console.log('Something went wrong..!!');\n" 
				+ "}\n"
				+ "} \n" 
				+ "}\n" 
				+ "}\n"
				+ "</script>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "Hello User\n"
				+ "<h1>INSERT EMPLOYEE DETAILS</h1>\n"
				+ "<form action=\"/Demo1/Insert/submit\" method=post>\n");
		int mode = Integer.parseInt(req.getParameter("mode"));
		if (mode > 1) {
			out.println("<label for=\"EmployeeId\">EmployeeId:\n"
					+ "</label><br>\n"
					+ "<input type=\"number\" id=\"EmployeeId\" name=\"EmployeeId\" required>\n"
					+ "<input type=\"button\" value=\"SEARCH\" onclick=\"sendInfo()\">\n\n");
		}
		out.println("<br> <br> "
				+ "<label for=\"CompanyName\">CompanyName:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" id=\"CompanyName\" name=\"CompanyName\" size=\"25\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"Salary\">Salary:\n"
				+ "</label><br>\n"
				+ "<input type=\"number\" id=\"Salary\" name=\"Salary\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"Designation\">Designation:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\"  id=\"Designation\" name=\"Designation\" size=\"10\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"Experience\">Experience:\n"
				+ "</label><br>\n"
				+ "<input type=\"number\" id=\"Experience\" name=\"Experience\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"Status\">Status:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" id=\"Status\" name=\"Status\" size=\"10\" required>\n"
				+ "<br> <br>\n"
				+ "<h2>PERSONAL DETAILS</h2>\n"
				+ "<label for=\"Name\">Name:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" id=\"Name\" name=\"Name\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PhoneNumber\">PhoneNumber:\n"
				+ "</label><br>\n"
				+ "<input type=\"number\" id=\"PhoneNumber\" name=\"PhoneNumber\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"EmailId\">EmailId:\n"
				+ "</label><br>\n"
				+ "<input type=\"email\" id=\"EmailId\" name=\"EmailId\" size=\"10\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"DateOfBirth\">DateOfBirth:\n"
				+ "</label><br>\n"
				+ "<input type=\"date\" id=\"DateOfBirth\" name=\"DateOfBirth\" size=\"10\" required>\n"
				+ "<br> <br>\n"
				+ "<h3>ADDRESS DETAILS</h3>\n"
				+ "<input type=\"radio\" id =\"CurrentAddress\" name=\"AddressDetails\" checked=\"checked\">\n"
				+ "<label for =\"CurrentAddress\">CurrentAddress</label><br>\n"
				+ "<input type=\"radio\" id =\"PermanentAddress\" name=\"AddressDetails\">\n"
				+ "<label for =\"PermanentAddress\">PermanentAddress</label><br>\n"
				+ "<div id=\"CurrentAddressDivision\">\n"
				+ "<h2>CURRENT ADDRESS</h2>\n"
				+ "<label for=\"Street\">Street:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"Street\" id=\"street1\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"City\">City:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"City\" id=\"city1\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"District\">District:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"District\" id=\"district1\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"State\">State:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"State\" id=\"state1\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PinCode\">PinCode:\n"
				+ "</label><br>\n"
				+ "<input type=\"number\" name=\"PinCode\" id=\"pincode1\" required>\n"
				+ "<br> <br>\n"
				+ "<input type=\"text\" name=\"AddressType\" id=\"AddressType1\" value=\"currentAddress\" style=\"visibility: hidden;\">\n"
				+ "<br> <br>\n"
				+ "</div>\n"
				+ "  <input type=\"checkbox\" id=\"same\" name=\"same\" onchange=\"addressValuesFunction()\" /> \n"
				+ "<label for=\"same\"> \n"
				+ "              If Permanent Address same select this box. \n"
				+ "          </label>  \n"
				+ "<div id=\"PermanentAddressDivision\">\n"
				+ "<h2>PERMANENT ADDRESS</h2>\n"
				+ "<label for=\"PermanentStreet\">Street:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"PermanentStreet\" id=\"street2\"size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PermanentCity\">City:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"PermanentCity\" id=\"city2\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PermanentDistrict\">District:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"PermanentDistrict\" id=\"district2\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PermanentState\">State:\n"
				+ "</label><br>\n"
				+ "<input type=\"text\" name=\"PermanentState\" id=\"state2\" size=\"15\" required>\n"
				+ "<br> <br>\n"
				+ "<label for=\"PermanentPinCode\">PinCode:\n"
				+ "</label><br>\n"
				+ "<input type=\"number\" name=\"PermanentPinCode\" id=\"pincode2\" required>\n"
				+ "<br> <br>\n"
				+ "<input type=\"text\" name=\"AddressType\" id=\"AddressType2\" value=\"permanentAddress\" style=\"visibility: hidden;\">\n"
				+ "</div>\n");
		int modeSubmit = Integer.parseInt(req.getParameter("mode"));
		if (modeSubmit == 1) {
			out.println("<input type=\"submit\" value=\"submit\">\n");
		} else if (modeSubmit == 2) {
			out.println("\"<input type=\"button\" value=\"Update\" onclick=\"update()\">");
		} else if (modeSubmit == 3) {
			out.println("\"<input type=\"button\" value=\"Delete\" onclick=\"Delete()\">");
		}
		out.println("</form>\n"
				+ "</body>\n"
				+ "</html>");
	}
}