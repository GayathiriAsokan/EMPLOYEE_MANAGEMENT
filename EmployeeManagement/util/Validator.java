/**
 * Provide the class necessary to create an Validator class
 * To communicate with  service class
 * @version 1.0
 * @since 1.0
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description EmployeeValidator used to validating employee data  
 * Meanwhile it checks for duplication for emailId and phoneNumber
 * @version 1.0
 */
public class Validator {

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
	 * @param date  String 
	 * @return isValid boolean - used to check whether it is a proper Date or not  
	 */
	public boolean isDateValid(String date) {
		int [] monthArray = {30,28,31,30,31,30,31,31,30,31,30,31};
		boolean isValid = false; 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			dateFormat.parse(date);
			String [] SplitDate = date.split("/");
			int month = Integer.parseInt(SplitDate[1]);
			int dateValue = Integer.parseInt(SplitDate[2]);
			int year = Integer.parseInt(SplitDate[0]);
			if (!(month >= 1 && month <= 12  && dateValue >= 1)) {
				return false;
			}
			if (isleapYearValid(year) && month ==2) {
				if (dateValue >=1 && dateValue <= monthArray[month-1]+1) {
					isValid  = true;
				}
			} else {
				if (monthArray[month-1] >= dateValue) {
					isValid = true;
				}
			}
		} catch (ParseException e) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * CheckEmailId is used for validation and duplication check
	 * @param emailId String - validate emailId
	 * @return emailId String - used to check whether it is a proper emailId or not
	 */ 
	public String checkEmailId(String emailId) {
		if (!(isEmailIdValid(emailId))) {
			System.out.println("Not a valid email kindly change emailId");
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
	 * CheckDate is used  for validation and duplication check
	 * @param Date String - validate Date
	 * @return String - used to check whether it is a proper Date or not
	 */
	public String checkDate(String date) {
		if (!(isDateValid(date))) {
			System.out.println("Not a Date valid  kindly change Date");
			date = null;
		}
		return date;
	}

	/**
	 * ProjectStatus gives the status of the project 
	 * @param endDate String - property in project
	 * @param actualEndDate  String - property in project
	 * @return String  Status of  the project
	 */
	public String projectStatus (String endDate, String actualEndDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String status = "";
		try {
			Date presentDate = new Date();
			Date dateEnd = dateFormat.parse(endDate);
			long noOfDays = presentDate.getTime() -  dateEnd.getTime();
			float differenceDate = (noOfDays / (1000*60*60*24));
			System.out.println("days" + differenceDate);
			if (differenceDate == 0) {
				status = status + " \n PROJECT IN PROGRESS";
			} else if (differenceDate < 0) {
				status = status + " \n PROJECT NOT  YET COMPLETED";
			} else {
				Date actualDate = dateFormat.parse(actualEndDate);
				long delayDays = dateEnd.getTime() - actualDate.getTime();
				float difference = (delayDays / (1000*60*60*24));
				if (delayDays == 0) {
					status = status + " \n PROJECT COMPLETED \n NO DELAY IN THE PROJECT";
				} else {
					String delayStatus = " \n PROJECT DELAYED";
					delayStatus = delayStatus + Float.toString(difference);
					status = status + " " + delayStatus + " Days";
				}
			}	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return status;
	}
}
