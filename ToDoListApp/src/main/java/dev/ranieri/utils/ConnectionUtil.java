package dev.ranieri.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
public static Connection createConnection() {
		
		try {
			Properties props = new Properties();
			
			// Sometimes the driver class does not load correctly into the JRE
			// this snippet forces the class to be loaded
			Class.forName("org.mariadb.jdbc.Driver");
			
			FileInputStream in = 
new FileInputStream(ConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());
			props.load(in);			
			String details = props.getProperty("condetails");			
			Connection conn = DriverManager.getConnection(details);
			
			return conn;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
