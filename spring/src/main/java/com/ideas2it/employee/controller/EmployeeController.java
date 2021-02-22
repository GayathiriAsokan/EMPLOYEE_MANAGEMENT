/**
 * Provide necessary to create a servlet class in controller
 */
package main.java.com.ideas2it.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import main.java.com.ideas2it.Exception.EmployeeIdNotExist;
import main.java.com.ideas2it.Logger.LoggerClass;
import main.java.com.ideas2it.employee.model.Address;
import main.java.com.ideas2it.employee.service.EmployeeService;
import main.java.com.ideas2it.employee.service.Impl.EmployeeServiceImpl;

/**
 * @description AddEmployee is used to add employee values 
 * @author GAYATHIRI
 */
@Controller
public class EmployeeController extends HttpServlet {

	@Autowired
	private EmployeeService employeeService;
	LoggerClass logger = new LoggerClass();
  	/**
	 * AddEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/")  
	public String Index() {
		return "Index";
	}

	/**
	 * AddEmployee method is used to add employee details 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping({ "/EmployeeController/Insert", "/EmployeeController/Update", "/EmployeeController/Delete", 
	"/EmployeeController/View" })  
	public String addEmployee() {
		return "AddEmployee";
	}

	/**
	 * InsertEmployeeToProject method is used to add project to employee
	 */
	@RequestMapping("/EmployeeController/AddProject")  
	public String insertEmployeeToProject() {
		return "EmployeeProject.jsp";
	}

	/**
	 * InsertEmployee method is used to add employee details 
	 */
	@RequestMapping("/EmployeeController/Insert/submit")  
	public String insertEmployee(@RequestParam Map<String, String> allRequestParam, Model model) {
		System.out.println(allRequestParam);
		String companyName = allRequestParam.get("CompanyName"); 
		double salary = Double.parseDouble(allRequestParam.get("Salary"));
		String designation = allRequestParam.get("Designation"); 
		int experience = Integer.parseInt(allRequestParam.get("Experience"));
		String status = allRequestParam.get("Status"); String name = allRequestParam.get("Name");
		long phoneNumber = Long.parseLong(allRequestParam.get("PhoneNumber"));
		String emailId = allRequestParam.get("EmailId"); 
		String dateOfBirth = allRequestParam.get("DateOfBirth"); 
		HashMap <String, Object> currentAddressMap = new HashMap <String, Object>();
		currentAddressMap.put("Street", allRequestParam.get("Street"));
		currentAddressMap.put("City", allRequestParam.get("City"));
		currentAddressMap.put("District", allRequestParam.get("District"));
		currentAddressMap.put("PinCode", Integer.parseInt(allRequestParam.get("PinCode")));
		currentAddressMap.put("State", allRequestParam.get("State"));
		currentAddressMap.put("AddressType", allRequestParam.get("AddressType"));
		HashMap <String, Object> permanentAddressMap = new HashMap <String, Object>(); 
		permanentAddressMap.put("Street",	allRequestParam.get("PermanentStreet")); 
		permanentAddressMap.put("City", allRequestParam.get("PermanentCity"));
		permanentAddressMap.put("District", allRequestParam.get("PermanentDistrict"));
		permanentAddressMap.put("PinCode", Integer.parseInt(allRequestParam.get("PermanentPinCode")));
		permanentAddressMap.put("State", allRequestParam.get("PermanentState"));
		permanentAddressMap.put("AddressType",
				allRequestParam.get("PermanentAddressType")); 
		String insertStatus = employeeService.insertEmployee(companyName, salary, designation, experience,
				status, name, phoneNumber, dateOfBirth, emailId, currentAddressMap,
				permanentAddressMap);
		model.addAttribute("status", insertStatus);
		System.out.println(insertStatus);
		return "EmployeeSubmission";
	}

	/**
	 * Display the details of employee for update,delete and view 
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws EmployeeIdNotExist 
	 */
	@RequestMapping("/EmployeeController/Update/ajax")  
	@ResponseBody
	public String viewEmployee(@RequestParam String EmployeeId) throws EmployeeIdNotExist {
		int employeeId = Integer.parseInt(EmployeeId);
		JSONArray arrayEmployeeValues = new JSONArray();
		try {
			if (employeeId != 0 && employeeId <= 23) {
				employeeService.getEmployee(employeeId);
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
				return arrayEmployeeValues.toString();
			} 
			else {
				throw new EmployeeIdNotExist("Employee Id Does Not Exist");
			}
		} catch (EmployeeIdNotExist e) {
			logger.loggerFatal(e.getMessage());
			e.printStackTrace();
		}
		return arrayEmployeeValues.toString();
	}

	/**
	 * UpdateEmployee method is used to update the employee details
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/Update/submit")  
	public String updateEmployee(@RequestParam Map<String, String> allRequestParam, Model model) {
		int employeeId = Integer.parseInt(allRequestParam.get("EmployeeId")); 
		long phoneNumber = Long.parseLong(allRequestParam.get("PhoneNumber"));
		String emailId = "EmailId";
		String status = employeeService.updatePersonalDetails(employeeId, phoneNumber, emailId);
		model.addAttribute("status", status);
		System.out.println(status);
		return "EmployeeSubmission";
	}

	/**
	 * DeleteEmployee is used to change the status of the employee
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/Delete/submit")  
	public String deleteEmployee(@RequestParam Map<String, String> allRequestParam, Model model) {
		int employeeId = Integer.parseInt(allRequestParam.get("EmployeeId")); 
		String status = employeeService.deleteEmployee(employeeId);
		model.addAttribute("status", status);
		System.out.println(status);
		return "EmployeeSubmission";
	}

	/**
	 * Display the details of the employee
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/EmployeeController/ViewAll")  
	public String displayEmployee() {
		return "ViewAllEmployee";
	}

	/**
	 * AddEmployeeToProject is used to add employee and project Details
	 * To insert and view the employee and project
	 * @throws IOException 
	 * @throws ServletException 
	 *
	@RequestMapping("/EmployeeController/AddProject/submit")
	public String addEmployeeToProject(@RequestParam Map <String, String> allRequestParam, Model model) {
		List <Integer> listProjectId = new ArrayList <Integer> ();
		int employeeId = Integer.parseInt(allRequestParam.get("Employee"));
		String [] project = allRequestParam.get("Project");
		for (int index = 0; index < project.length ; index ++) {
			System.out.println(project[index]);
			listProjectId.add(Integer.parseInt(project[index]));
		}
		System.out.println(listProjectId);
		String status = employeeService.addProjectEmployee(listProjectId, employeeId);
		model.addAttribute("status", status);
		System.out.println(status);
		return "EmployeeSubmission";
	}*/
}

