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
    private int pinCode;
    private String street;
    private String district;
    private String city;
    private String state;

    /**
     * Default Constructor which creates an empty object of Address
     */
    public Address() {
    }

    /**
     * Parameterized constructor with parameters  city,district,state
     * Asigning values using this keyword    
     */
    public Address(String street, String city, String district, int pinCode, String state) {
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.street = street;
        this.district = district;
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

    @Override
    public String toString() {
        return "\n Address : PinCode : " + getPinCode() + "\n Street : " + getStreet() + "\n City : " + getCity()
                + "\n District : " + getDistrict() + "\n State : " + getState();
    }
}

