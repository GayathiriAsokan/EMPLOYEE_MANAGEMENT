/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package com.ideas2it.employee.model;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.model.Employee;
/**
 * PersonalDetails class is a model class
 * It is used to hold the user personal details such as  name,emailid,phonenumber
 * It  holds Address details 
 * @version 1.0
 */
public class PersonalDetails {
    private int personalId;
	private String name;
    private String emailId;
    private String dateOfBirth;
    private String phoneNumber;
    private Employee employee;
    private Address address;
    private List<Address> addressList = new ArrayList<Address>();

    /**
     * Default Constructor which creates an empty object of PersonalDetails
     */
    public PersonalDetails() {
    }

    /**
     * Parameterized constructor with parameters of name, dateOfBirth, phoneNumber
     * Asigning values using this keyword
     */
    public PersonalDetails(int personalId, String name, String emailId, String dateOfBirth, String phoneNumber) {
    	this.personalId = personalId;
    	this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
    }
	
	  public void setAddressList(Address address) { 
		  addressList.add(address); 
		  }
	  
	  public List<Address> getAddressList() {
		  return addressList;
		  }
	 

    public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return " \n PersonalDetails : \n Name : " + getName() + "\n Phonenumber : " + getPhoneNumber() + "\n EmailId : " + getEmailId() +
                "\n Date of birth : " + getDateOfBirth() + " " + getEmployee() + " " + getAddressList().toString();
    }
}
