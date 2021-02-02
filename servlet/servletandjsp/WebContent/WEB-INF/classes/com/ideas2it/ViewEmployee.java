package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.EmployeeServiceImpl;

public class ViewEmployee extends HttpServlet {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
}
