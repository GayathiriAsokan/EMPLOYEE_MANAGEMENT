/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package main.java.com.ideas2it.employee.model;

import java.util.Set;

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
	private Set<Address> addressSet;

	/**
	 * Default Constructor which creates an empty object of PersonalDetails
	 */
	public PersonalDetails() {
	}

	/**
	 * Parameterized constructor with parameters of name, dateOfBirth, phoneNumber
	 * Asigning values using this keyword
	 */
	public PersonalDetails(String name, String emailId, String dateOfBirth, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

	public void setAddressSet(Set <Address> address) { 
		addressSet = address; 
	}

	public Set<Address> getAddressSet() {
		return addressSet;
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

	@Override
	public String toString() {
		return " \n PersonalDetails : \n  PersonalId" + getPersonalId() + "\n Name :" + getName() + "\n Phonenumber : " + getPhoneNumber() + "\n EmailId : " + getEmailId() +
				"\n Date of birth : " + getDateOfBirth() + " " + getAddressSet().toString();
	}
}
