/**
 * Provide the class necessary to create an model class
 * To communicate with service class
 *
 * @since 1.0
 */
package com.ideas2it.employee.model;


/**
 * Employee class is a model class 
 * It is used to hold the user employee details such as project name, salary
 * It holds Personal details
 * @version 1.0
 */
public class Employee {
    private int employeeId;
    private String companyName;
    private PersonalDetails personaldetails;
    private long salary;
    private int experience;
    private String designation;

    /**
     * Default Constructor which creates an empty object of Employee
     */
    public Employee() {
    }

    /**
     * Parameterized constructor with parameters of companyName and salary
     * Asigning values using this keyword
     */
    public Employee(int employeeId, String companyName, long salary, int experience, String designation) {
        this.companyName = companyName;
        this.salary = salary;
        this.employeeId = employeeId;
        this.experience = experience;
        this.designation = designation;
    }

   public PersonalDetails getPersonalDetails() {
       return personaldetails;
    }

   public void setPersonalDetails(PersonalDetails personaldetails) {
       this.personaldetails = personaldetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "\n Employee : EmployeeId : " + getEmployeeId() + "\n CompanyName : " + getCompanyName() + "\n Salary : "
                + getSalary() + "\n Designation : " + getDesignation() + "\n Experience : " + getExperience()  + " "
                + getPersonalDetails().toString();
    }
}
