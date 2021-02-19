/**
 * Provide necessary class to create Exception to define the user defined exception
 */
package main.java.com.ideas2it.Exception;

/**
 * @description CustomException is used to print the user defined exception
 * @author GAYATHIRI
 * @return String
 */
public class EmployeeIdNotExist extends Exception{
	private String message;
	
	/**
	 * Asigning values using this keyword    
	 * @param message
	 */
	public EmployeeIdNotExist(String message) {
		super(message);
	}
}
