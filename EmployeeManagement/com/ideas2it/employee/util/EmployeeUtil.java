/**
 * Provide the class necessary to create an Validator class
 * To communicate with  service 
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it.employee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.PersonalDetails;

/**
 * @description EmployeeValidator used to validating employee data  
 * Meanwhile it checks for duplication for emailId and phoneNumber
 * @version 1.0
 */
public class EmployeeUtil {

    /**
     * In the method isEmailValid used to  validate the emailId 
     * @param emailId  String - check validation of  emailId
     * @return  boolean - to verify emailId
     */
    public boolean isEmailIdValid(String emailId) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
	       Matcher matcher = pattern.matcher(emailId);
        if (matcher.matches()) {
            return true;
        }   
        return false;
    }
     
    /**
     * In this isPhoneNumber used to validate the phone number length
     * @param phoneNumber long  - check valid in the employee details
     * @return isValid boolean - to verify phoneNumber
     */
    public boolean isPhoneNumberValid(Long phoneNumber) {
        boolean isValid = false;
        String mobileNumber = Long.toString(phoneNumber);
        if (mobileNumber.length() == 10) {
            isValid = true;
        }
        return isValid;
    }
    
    /**
	    * In the method is to check the year in the date of birth is leap year  or not 
     * @param  year int -year to validate dateOfBirth
     * @return boolean - to verify dateOfBirth
	    */
    public boolean isleapYearValid(int year) {
		      if (((year % 4 ==0) && (year % 100 != 0) || (year % 400 ==0))) {
			         return true;
		      } else {
			         return false;	
		      }
	   }
    
    /**
     * IsDateValid user need to enter phone number repeatedly until a valid phone number
     * @param dateOfBirth - dateOfbirth in the employee details 
     * @return isValid boolean - used to check whether it is a proper DateOfBirth or not  
	    */
    public boolean isDateOfBirthValid(String dateOfBirth) {
	       int [] monthArray = {30,28,31,30,31,30,31,31,30,31,30,31};
        boolean isValid = false; 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            dateFormat.parse(dateOfBirth);
			         String [] SplitDate = dateOfBirth.split("/");
			         int month = Integer.parseInt(SplitDate[1]);
			         int date = Integer.parseInt(SplitDate[2]);
	           int year = Integer.parseInt(SplitDate[0]);
			         if (!(month >= 1 && month <= 12  && date >= 1)) {
				            return false;
			         }
			         if (isleapYearValid(year) && month ==2) {
				            if (date >=1 && date <= monthArray[month-1]+1) {
					               isValid  = true;
				            }
            } else {
				            if (monthArray[month-1] >= date) {
					               isValid = true;
				            }
			         }
		      } catch (ParseException e) {
			         isValid = false;
		      }
        return isValid;
    }
    
    /**
     * CheckEmailId is used  for validation and duplication check
     * @param emailId String - validate emailId
     * @return emailId String - used to check whether it is a proper emailId or not
     */ 
    public String checkEmailId(String emailId) {
        if (!(isEmailIdValid(emailId))) {
            System.out.println("Not a valid email kindly change email");
            emailId = null;
        }
        return emailId;    
    }
    
    /**
     * CheckphoneNumber is used  for validation and duplication check
     * @param phoneNumber long - validate phoneNumber
     * @return phoneNumber long - used to check whether it is a proper phoneNumber or not
     */ 
    public Long checkPhoneNumber(Long phoneNumber) {
        if (!(isPhoneNumberValid(phoneNumber))) {
            System.out.println("Not a valid phone number kindly change phone number");
            phoneNumber = (long) 0;
        }
        return phoneNumber;    
    }
    
    /**
     * CheckDateOfBirth is used  for validation and duplication check
     * @param DateOfBirth String - validate emailId
     * @return DateOfBirth String - used to check whether it is a proper DateOfBirth or not
     */
    public String checkDateOfBirth(String dateOfBirth) {
        if (!(isDateOfBirthValid(dateOfBirth))) {
            System.out.println("Not a DateOfBirth valid  kindly change DateOfBirth");
            dateOfBirth = null;
        }
        return dateOfBirth;
    }
}
