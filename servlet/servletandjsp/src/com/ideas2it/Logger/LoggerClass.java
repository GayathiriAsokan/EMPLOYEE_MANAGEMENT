/**
 * Provide necessary to create a logger class to find find error easily
 */
package com.ideas2it.Logger;

import org.jboss.logging.Logger;

/**
 * @description Logger class is used for sent the information and error messages
 * @author ubuntu
 *
 */
public class LoggerClass {
	private Logger logger = Logger.getLogger(LoggerClass.class);

	/**
	 * To display error message from logger
	 */
	 public void loggerError(String message) {
		 logger.error(message);
	 } 
	  
	 /**
	  * To display info message from logger
	  */
	 public void loggerInfo(String message) {
		 logger.info(message);
	 }
}
