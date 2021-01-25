package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployee extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 PrintWriter out = res.getWriter(); 
		 out.println("<html>\n"
		 		+ "<head>\n"
		 		+ "<title>INSERT EMPLOYEE DETAILS</title>\n"
		 		+ "<script>\n");
			/*
			 * + "var request;\n" + "function sendInfo() { \n" +
			 * "var EmployeeId=document.getElementById("EmployeeId").value;\n"
			 */
		 		/*
					 * + "function addressFunction() {\n" +
					 * "	if (document.getElementById(\"CurrentAddress\").checked) {\n" +
					 * "		alert(document.getElementById(\"CurrentAddressDivision\").style.visibility='visible');\n"
					 * +
					 * "		alert(document.getElementById(\"PermanentAddressDivision\").style.visibility='hidden');\n"
					 * + "	} else if (document.getElementById(\"PermanentAddress\").checked) {\n" +
					 * "		alert(document.getElementById(\"PermanentAddressDivision\").style.visibility='visible');\n"
					 * +
					 * "		alert(document.getElementById(\"CurrentAddressDivision\").style.visibility='hidden');\n"
					 * + "	}\n" + "}\n"
					 */
		 		out.println("function addressValuesFunction() {\n"
		 		+ " if (document.getElementById( \"same\").checked) { \n"
		 		+ "      document.getElementById(\"street2\").value =  document.getElementById(\"street1\").value; \n"
		 		+ "      document.getElementById(\"city2\").value =  document.getElementById(\"city1\").value; \n"
		 		+ "      document.getElementById(\"district2\").value =  document.getElementById(\"district1\").value; \n"
		 		+ "      document.getElementById(\"state2\").value =  document.getElementById(\"state1\").value; \n"
		 		+ "      document.getElementById(\"pincode2\").value = document.getElementById(\"pincode1\").value; \n"
		 		+ "  } else { \n"
		 		+ "      document.getElementById(\"street2\").value = \"\";\n"
		 		+ "      document.getElementById(\"city2\").value = \"\";\n"
		 		+ "      document.getElementById(\"district2\").value = \"\"; \n"
		 		+ "      document.getElementById(\"state2\").value = \"\";  \n"
		 		+ "      document.getElementById(\"pincode2\").value =  \"\";\n"
		 		+ "  } \n"
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
		    		 		+ "<br> <br>\n"
		    		 		+ "<input type=\"button\" value=\"SEARCH\" onclick=\"sendInfo()\">\n\n");
		        }
		 		out.println("<label for=\"CompanyName\">CompanyName:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"text\" name=\"CompanyName\" size=\"25\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"Salary\">Salary:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"number\" name=\"Salary\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"Designation\">Designation:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"text\" name=\"Designation\" size=\"10\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"Experience\">Experience:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"number\" name=\"Experience\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"Status\">Status:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"text\" name=\"Status\" size=\"10\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<h2>PERSONAL DETAILS</h2>\n"
		 		+ "<label for=\"Name\">Name:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"text\" name=\"Name\" size=\"15\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"PhoneNumber\">PhoneNumber:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"number\" name=\"PhoneNumber\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"EmailId\">EmailId:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"email\" name=\"EmailId\" size=\"10\" required>\n"
		 		+ "<br> <br>\n"
		 		+ "<label for=\"DateOfBirth\">DateOfBirth:\n"
		 		+ "</label><br>\n"
		 		+ "<input type=\"date\" name=\"DateOfBirth\" size=\"10\" required>\n"
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
		 		+ "<input type=\"text\" name=\"AddressType\" id=\"AddressType1\" value=\"permanentAddress\" style=\"visibility: hidden;\">\n"
		 		+ "</div>\n"
		 		+ "<input type=\"submit\" value=\"submit\">\n"
		 		+ "</form>\n"
		 		+ "</body>\n"
		 		+ "</html>");
	}
}
