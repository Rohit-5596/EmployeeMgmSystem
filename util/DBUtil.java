package com.cg.ems.util;
import java.util.Properties;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import com.cg.ems.exception.*;

public class DBUtil {

	
	static String unm;
	static String pwd;
	static String url;
	static String driver;
	static Connection con=null;
	
	public static Connection getCon() throws EmployeeException{
		try {
		Properties dbProps=getDBInfo();
		unm=dbProps.getProperty("dbUsername");
		pwd=dbProps.getProperty("dbPassword");
		url=dbProps.getProperty("dbUrl");
		driver=dbProps.getProperty("dbDriver");
				
		Class.forName(driver);
		
		con=DriverManager.getConnection(url,unm,pwd);
		}
		catch(Exception ee) {
			throw new EmployeeException(ee.getMessage());
		}
		return con;
				
				
		
	}
	
	public static Properties getDBInfo() throws IOException {
		
		FileReader fr=new FileReader("dbInfo.properties");
		Properties myProps=new Properties();
		myProps.load(fr);
		return myProps;
	}
}
