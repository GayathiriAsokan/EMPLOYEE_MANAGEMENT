/**
 * Provide the class necessary to create a connector class
 * To communicate with employee dao and project dao classes
 * @version 1.0
 * @since 1.0
 */
package com.ideas2it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @description EmployeeDao made jdbc connectivity for the employeeApplication
 * Using database we can insert ,update,select,delete data using sql query
 * @version 1.0
 * @author GAYATHIRI
 */ 
public class Connector {
    
    /**
     * Connnection method is used to establishing a connection using jdbc
     * @return connection Connection -to insert,select,update,delete data using sql query
     */ 
    public static Connection getConnection() {
        Connection connection = null;
		      String driver = "com.mysql.jdbc.Driver";
		      String url = "jdbc:mysql://localhost:3306/Employee_Application";
		      String userName = "root";
		      String password = "Rooter@12345";
        try {
            Class.forName(driver);
			         connection = DriverManager.getConnection(url, userName, password);
			         System.out.println("connected");  
        } catch (Exception e) {
			         System.out.println("Could not load the connection" + e.getMessage());
			         e.printStackTrace();
		      }
        return connection;
    }
    
    /** 
     * CloseConnection used to close the preparedStatement and connection 
     * @param connection Connection - to close the conection 
     * @param preparedStatement PreparedStatement - close the prepared statement
     */
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
			         System.out.println("Could not load the connection" + e.getMessage());
        } 
    }
}
