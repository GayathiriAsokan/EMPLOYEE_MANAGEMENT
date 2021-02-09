/**
 * Provide necessary to create a servlet class in controller
 */
package com.ideas2it.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.Impl.EmployeeServiceImpl;

/**
 * @description AddEmployee is used to add employee values 
 * @author GAYATHIRI
 */
public class EmployeeController extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	/**
	 * This method is used to save the project details using jsp file
	 * By checking the mode crud operations are done
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/EmployeeController")[1]; 
		System.out.println(urlMapping);
		switch(urlMapping) {
		case "/Insert" :
		case "/Update" :
		case "/Delete":
		case "/View" :
			addEmployee(request, response);
			break;
		case "/Update/ajax" :
			viewEmployee(request, response);
			break;
		case "/ViewAll" :
			displayEmployee(request, response);
			break;
		case "/AddProject" :
			insertEmployeeToProject(request, response);
			break;
		}
	}

	/**
	 * This method is used to save the project details using jsp file
	 * By checking the mode crud operations are done
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getServletPath());
		String urlMapping=request.getServletPath().split("/EmployeeController")[1];
		switch(urlMapping) {
		case "/Insert/submit" :
			insertEmployee(request, response);
			break;
		case "/Update/submit" :
			updateEmployee(request, response);
			break;
		case "/Delete/submit" :
			deleteEmployee(request, response) ;
			break;
		case "/AddProject/submit" :
			addEmployeeToProject(request, response) ;
			break;
		}
	}

	/**
	 * AddEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/AddEmployee.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * InsertEmployeeToProject method is used to add project to employee
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertEmployeeToProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/EmployeeProject.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * InsertEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String companyName = request.getParameter("CompanyName");
		double salary = Double.parseDouble(request.getParameter("Salary"));
		String designation = request.getParameter("Designation");
		int experience = Integer.parseInt(request.getParameter("Experience"));
		String status = request.getParameter("Status");
		String name = request.getParameter("Name");
		long phoneNumber = Long.parseLong(request.getParameter("PhoneNumber"));
		String emailId = request.getParameter("EmailId");
		String dateOfBirth = request.getParameter("DateOfBirth");
		HashMap <String, Object> currentAddressMap = new HashMap <String, Object>();
		currentAddressMap.put("Street", request.getParameter("Street"));
		currentAddressMap.put("City", request.getParameter("City"));
		currentAddressMap.put("District", request.getParameter("District"));
		currentAddressMap.put("PinCode", Integer.parseInt(request.getParameter("PinCode")));
		currentAddressMap.put("State", request.getParameter("State"));
		currentAddressMap.put("AddressType", request.getParameter("AddressType"));
		HashMap <String, Object> permanentAddressMap = new HashMap <String, Object>();
		permanentAddressMap.put("Street", request.getParameter("PermanentStreet"));
		permanentAddressMap.put("City", request.getParameter("PermanentCity"));
		permanentAddressMap.put("District", request.getParameter("PermanentDistrict"));
		permanentAddressMap.put("PinCode", Integer.parseInt(request.getParameter("PermanentPinCode")));
		permanentAddressMap.put("State", request.getParameter("PermanentState"));
		permanentAddressMap.put("AddressType", request.getParameter("PermanentAddressType"));
		String insertStatus = employeeService.insertEmployee(companyName, salary, designation, experience, status,
				name, phoneNumber, dateOfBirth, emailId, currentAddressMap, permanentAddressMap);
		System.out.println(insertStatus);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.println(insertStatus);
	}

	/**
	 * Display the details of employee for update,delete and view 
	 */
	public void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int employeeId = Integer.parseInt(request.getParameter("EmployeeId"));
		if (employeeId != 0) {
			response.setContentType("text/html");
			employeeService.getEmployee(employeeId);
			JSONArray arrayEmployeeValues = new JSONArray();
			JSONObject employee = new JSONObject();
			employee.put("companyName", employeeService.getEmployee(employeeId).getCompanyName());
			employee.put("salary", employeeService.getEmployee(employeeId).getSalary());
			employee.put("designation", employeeService.getEmployee(employeeId).getDesignation());
			employee.put("experience", employeeService.getEmployee(employeeId).getExperience());
			employee.put("status", employeeService.getEmployee(employeeId).getStatus());
			employee.put("name",employeeService.getEmployee(employeeId).getPersonalDetails().getName());
			employee.put("phoneNumber",
					employeeService.getEmployee(employeeId).getPersonalDetails().getPhoneNumber());
			employee.put("emailId",
					employeeService.getEmployee(employeeId).getPersonalDetails().getEmailId());
			String dateString = employeeService.getEmployee(employeeId).getPersonalDetails().getDateOfBirth().replace("/", "-");
			employee.put("dateOfBirth", dateString);
			List <Address> addressList = new ArrayList <Address> (employeeService.getEmployee(employeeId).getPersonalDetails().getAddressSet());
			employee.put("currentStreet",addressList.get(0).getStreet());
			employee.put("currentCity",addressList.get(0).getCity());
			employee.put("currentDistrict",addressList.get(0).getDistrict());
			employee.put("currentState",addressList.get(0).getState());
			employee.put("currentPinCode",addressList.get(0).getPinCode());
			employee.put("currentAddressType",addressList.get(0).getAddressType());
			employee.put("permanentStreet",addressList.get(1).getStreet());
			employee.put("permanentCity",addressList.get(1).getCity());
			employee.put("permanentDistrict",addressList.get(1).getDistrict());
			employee.put("permanentState",addressList.get(1).getState());
			employee.put("permanentPinCode",addressList.get(1).getPinCode());
			employee.put("permanentAddressType",addressList.get(1).getAddressType());
			System.out.println(employee);
			arrayEmployeeValues.put(employee);
			response.setContentType("application/json");
			response.getWriter().write(arrayEmployeeValues.toString());
		}
	}

	/**
	 * UpdateEmployee method is used to update the employee details
	 * @throws IOException 
	 */
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("EmployeeId"));
		int employeeId = Integer.parseInt(request.getParameter("EmployeeId")); 
		long phoneNumber = Long.parseLong(request.getParameter("PhoneNumber"));
		String emailId = request.getParameter("EmailId");
		String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.println("<html>\n"
				+ "<head>\n"
				+ "<title>INSERT EMPLOYEE DETAILS</title>\n"
				+ "<p><a href=\"/Demo1/EmployeeController/Delete?mode=3\">UPDATE</a>"
				+ "<p><a href=\"/Demo1/Index.jsp\" > HOME</a>"
				+ "<br> <br>\n");
		out.println(status);
	}

	/**
	 * DeleteEmployee is used to change the status of the employee
	 */
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int employeeId = Integer.parseInt(request.getParameter("EmployeeId")); 
		String status = employeeService.deleteEmployee(employeeId);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.println("<html>\n"
				+ "<head>\n"
				+ "<title>INSERT EMPLOYEE DETAILS</title>\n"
				+ "<p><a href=\"/Demo1/EmployeeController/View?mode=4\">Display Employee</a>"
				+ "<p><a href=\"/Demo1/Index.jsp\" > HOME</a>"
				+ "<br> <br>\n");
		out.println(status);
	}

	/**
	 * Display the details of the employee
	 */
	public void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/view/jsp/ViewAllEmployee.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 */
	public void addEmployeeToProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List <Integer> listProjectId = new ArrayList <Integer> ();
		int employeeId = Integer.parseInt(request.getParameter("Employee"));
		String [] project = request.getParameterValues("Project");
		for (int index = 0; index < project.length ; index ++) {
			System.out.println(project[index]);
			listProjectId.add(Integer.parseInt(project[index]));
		}
		System.out.println(listProjectId);
		String status = employeeService.addProjectEmployee(listProjectId, employeeId);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		out.println("<html>\n"
				+ "<head>\n"
				+ "<title>INSERT EMPLOYEE DETAILS</title>\n"
				+ "<p><a href=\"/Demo1/Index.jsp\" > HOME</a>"
				+ "<br> <br>\n");
		out.println(status);
	}
}

