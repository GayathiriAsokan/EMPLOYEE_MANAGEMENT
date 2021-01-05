/**
 * Provide the class necessary to create a dao class
 * To communicate with service and model classes
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas2it.Connector;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;

/**
 * @description EmployeeDao made jdbc connectivity for the employeeApplication
 * Using database we can insert ,update,select,delete data using sql query
 * @version 1.0
 * @author GAYATHIRI
 */ 
public class EmployeeDao {
	
    Connector connector = new Connector();

    /**
     * InsertEmployee is used to insert the employee data using insert query
     * @param employeeId int 
     * @param salary String
     * @param companyName String
     * @return rowCount int - to find whether the employee data inserted or not
     */ 
    public int insertEmployee(int employeeId, long salary, String companyName, String designation, int experience) {
        System.out.println("EMPLOYEE DATA");
        int rowCount = 0;
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement("insert into employee Values(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employeeId);
			         preparedStatement.setLong(2, salary );
			         preparedStatement.setString(3, companyName);
            preparedStatement.setString(4, designation);
            preparedStatement.setInt(5, experience);
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the insert operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
    return rowCount;
    }  
 
    /** 
     * InsertPersonalDetails is used to insert the values using Insert query
     * @param employeeId int 
     * @param name String
     * @param emailId String
     * @param dateOfBirth String
     * @param phoneNumber long
     * @return rowCount int - to find whether the PersonalDetails inserted or not
     */
    public int insertPersonalDetails(int employeeId, String name, long phoneNumber, String emailId, String dateOfBirth) {
        System.out.println("PERSONAL DATA");
        int rowCount = 0;
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement("insert into personal_details Values(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employeeId);
			         preparedStatement.setString(2, name);
            preparedStatement.setLong(3, phoneNumber );
            preparedStatement.setString(4, emailId);
            preparedStatement.setString(5, dateOfBirth);
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the insert operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return rowCount;
    } 
    
    /**
     * InsertAddress is used to insert the values using Insert query
     * @param employeeId int 
     * @param street String
     * @param city String
     * @param district String
     * @param state String
     * @param pinCode long
     * @return rowCount int - to find whether the row inserted or not
     */
    public int insertAddress(int employeeId, Address currentAddress, Address permanentAddress) {
        System.out.println("ADDRESS DATA");
        int rowCount = 0;
        Connection connection = connector.getConnection();
        try { 
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement("insert into address Values(?, ?, ?, ?, ?, ?, ?), (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, employeeId);
			         preparedStatement.setString(2, currentAddress.getStreet());
            preparedStatement.setString(3, currentAddress.getCity());
            preparedStatement.setString(4, currentAddress.getDistrict());
            preparedStatement.setString(5, currentAddress.getState());
            preparedStatement.setInt(6, currentAddress.getPinCode());
            preparedStatement.setString(7, "currentAddress");
            preparedStatement.setInt(8, employeeId);
			         preparedStatement.setString(9, permanentAddress.getStreet());
            preparedStatement.setString(10, permanentAddress.getCity());
            preparedStatement.setString(11, permanentAddress.getDistrict());
            preparedStatement.setString(12, permanentAddress.getState());
            preparedStatement.setInt(13, permanentAddress.getPinCode());
            preparedStatement.setString(14, "permanentAddress");
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowCount;
        } catch (Exception e) {
			         System.out.println("Could not load the insert operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return rowCount;
    }   
  
    /**ViewEmployee is used to view the employee details using select query
     * @param employeeId int
     * @param viewFlag boolean
     * @return employeeList List <Employee>
     */
    public List <HashMap <String, Object>> viewEmployee(int employeeId, boolean viewFlag) {
        List <HashMap <String, Object>> employeeList = new ArrayList <HashMap <String, Object>>();
        Connection connection = connector.getConnection();
        StringBuilder viewQuery = new StringBuilder("select emp.employee_id,emp.salary,emp.company_name,detail.name,")          
        .append("detail.phone_number,detail.email_id,detail.dateof_birth,address.Address_Type,")
        .append("address.street,address.city,address.district,address.state,address.pin_code from employee as ") 
        .append("emp inner join personal_details as detail on emp.employee_id = detail.employee_id inner join ")
        .append("address as address on emp.employee_id = address.employee_id"); 
        if (viewFlag) {
            viewQuery.append(" where emp.employee_id = ?");
        }
        try {
            PreparedStatement preparedStatement = null;
			         preparedStatement = connection.prepareStatement(viewQuery.toString());
            if (viewFlag) {
                preparedStatement.setInt(1, employeeId);
            }   
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HashMap <String, Object> employeeMap = new HashMap <String, Object> ();
                employeeMap.put("Salary", resultSet.getLong("salary"));
                employeeMap.put("CompanyName", resultSet.getString("company_name"));
                employeeMap.put("EmployeeId", resultSet.getInt("employee_id"));
                employeeMap.put("Name", resultSet.getString("name"));
                employeeMap.put("EmailId", resultSet.getString("email_id"));
                employeeMap.put("PhoneNumber", resultSet.getLong("phone_number"));
                employeeMap.put("DateOfBirth", resultSet.getString("dateof_birth"));
                employeeMap.put("AddressType", resultSet.getString("Address_type"));
                employeeMap.put("Street", resultSet.getString("street"));
                employeeMap.put("City", resultSet.getString("city"));
                employeeMap.put("District", resultSet.getString("district"));
                employeeMap.put("State", resultSet.getString("state"));
                employeeMap.put("PinCode", resultSet.getInt("pin_code"));
                if (resultSet.next()) {
                    employeeMap.put("Permanent AddressType", resultSet.getString("Address_type"));
                    employeeMap.put("Permanent Street", resultSet.getString("street"));
                    employeeMap.put("Permanent City", resultSet.getString("city"));
                    employeeMap.put("Permanent District", resultSet.getString("district"));
                    employeeMap.put("Permanent State", resultSet.getString("state"));
                    employeeMap.put("Permanent PinCode", resultSet.getInt("pin_code"));
                    employeeList.add(employeeMap);
                }
            }
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the view operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return employeeList;
    }
    
    /**
     * IsDuplicate is used to check value already present in the Personal_details table or not
     * @param  employeeId int 
     * @param emailId String  
     * @param phoneNumber long
     * @return employeeList List <Integer>  - to find how many rows affected  
     */
    public List <Integer> isDuplicate(int employeeId, long phoneNumber, String emailId) {
        List <Integer> employeeList = new ArrayList <Integer>();
        int countRow = 0;
        Connection connection = connector.getConnection();
        String checkQuery = "select count(employee_id) from personal_details where employee_id = ?";
        checkQuery = checkQuery + " union all select count(employee_id) from personal_details where  phone_number = ?" 
                    " union all select count(employee_id) from personal_details where email_id = ?";
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setLong(2, phoneNumber );
            preparedStatement.setString(3, emailId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(resultSet.getInt(1));
            }
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load th eDuplicate operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }  
        return employeeList; 
    } 
    
    /**
     * DeleteAddress is used to delete entries in Address table
     * @param employeId int
     * @return countAddress int- to find how many rows affected
     */
    public int deleteAddress(int employeeId, String addressType) {
        Connection connection = connector.getConnection();
        int countAddress = 0; 
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("delete from address where Address_type = ? and employee_id = ?");
            preparedStatement.setString(1, addressType);
            preparedStatement.setInt(2, employeeId);
            countAddress = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the delete operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return countAddress;
    }

    /**
     * DeleteEmployee is used to delete entries in Employee
     * @param employeId int
     * @return countEmployee int - to find how many rows affected
     */
    public int deleteEmployee(int employeeId) {
        Connection connection = connector.getConnection();
        int countEmployee = 0; 
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("update employee set designation = null where employee_id = ?");
            preparedStatement.setInt(1, employeeId);         
            countEmployee = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the delete operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return countEmployee; 
    }
    
    /**
     * UpdatePersonalDetails is used to change the Personal_details values of emailId, phoneNumber
     * @param  employeeId int 
     * @param emailId String  
     * @param phoneNumber long 
     * @return updateCount int -to check the modification or done in a table or not
     */
    public int updatePersonalDetails(int employeeId, long phoneNumber, String emailId) {
        Connection connection = connector.getConnection();
        int updateCount = 0;
        String updatePersonalDetail = "update personal_details set phone_number = ?, email_id = ? where employee_id = ?";
        try {
            PreparedStatement preparedStatement = null; 
            preparedStatement = connection.prepareStatement(updatePersonalDetail);
            preparedStatement.setLong(1, phoneNumber);
            preparedStatement.setString(2, emailId);
            preparedStatement.setInt(3, employeeId);
            updateCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
			         System.out.println("Could not load the update operation" + e.getMessage());
			         e.printStackTrace();
		      } finally {
            connector.closeConnection(connection);
        }
        return updateCount;
    } 
}
