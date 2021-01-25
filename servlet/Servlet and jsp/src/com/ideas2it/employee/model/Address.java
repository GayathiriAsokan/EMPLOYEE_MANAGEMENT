/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package com.ideas2it.employee.model;


/**
 * Address class is a model class
 * It is used to hold the user address details such as city,district,state  
 * @version 1.0
 */
public class Address {
	private int addressId;
	private int pinCode;
	private String street;
	private String district;
	private String city;
	private String state;
	private String addressType;
	private PersonalDetails personalDetails;

	/**
	 * Default Constructor which creates an empty object of Address
	 */
	public Address() {
	}

	/**
	 * Parameterized constructor with parameters  city,district,state
	 * Asigning values using this keyword    
	 */
	public Address(String street, String city, String district, int pinCode, String state, String addressType) {
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.street = street;
		this.district = district;
		this.addressType = addressType;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personal_details) {
		this.personalDetails = personal_details;
	}

	@Override
	public String toString() {
		return "\n Address : AddressId "  +  getAddressId() + "\n PinCode : " + getPinCode() + "\n Street : " + getStreet() + "\n City : " + getCity()
		+ "\n District : " + getDistrict() + "\n State : " + getState() + "\n AddressType : " + getAddressType(); 
	}
}

