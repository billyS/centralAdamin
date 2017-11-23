package uk.co.F1x2Games;



import java.io.IOException;
import java.sql.* ;
import javax.sql.* ;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.naming.* ;
import java.util.Properties;


public class DatabaseUtils  {

    //Connection con;
	String driver="";
   // String url="";  
	String user="";
	String password="";
    String servletPath="http:localhost:8080/servlet"; 
	Properties properties;
	PropertyPlaceholderConfigurer props2;

	private static DatabaseUtils dbu = null;
	
	private DatabaseUtils(){
		
		try {
			properties= PropertiesLoaderUtils.loadAllProperties("General.properties");
			props2 = new PropertyPlaceholderConfigurer();
			props2.setProperties(properties);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//properties=uk.co.F1x2Games.PropertyLoader.loadProperties("uk.co.F1x2Games.Properties.General");
	}

	
	public static DatabaseUtils getInstance()  {
		if (dbu == null) {
			dbu = new DatabaseUtils();
		}
				
		return dbu;
    }


	public Connection getConnection() throws SQLException{
		driver=properties.getProperty("driver");
		String url=properties.getProperty("databaseURL");
		user=properties.getProperty("db_username");
		password=properties.getProperty("db_password");

		  try {  
				Class.forName(driver);
					 } catch(java.lang.ClassNotFoundException e) {
					System.err.print("ClassNotFoundException: ");
					System.err.println(e.getMessage());
					}

					return DriverManager.getConnection(url,user,password);		
		//return con;
	}

public Connection getConnection(String dbName) throws SQLException{
		driver=properties.getProperty("driver");
		String url=properties.getProperty("databaseURL_"+dbName);
		user=properties.getProperty("db_username");
		password=properties.getProperty("db_password");

		  try {  
				Class.forName(driver);
					 } catch(java.lang.ClassNotFoundException e) {
					System.err.print("ClassNotFoundException: ");
					System.err.println(e.getMessage());
					}

					return DriverManager.getConnection(url,user,password);		
		//return con;
	}



	public void closeConnection() throws SQLException{
		//if (con!=null)con.close();
		// do nothing as this is breaking when used by the timer games on clients who do not have batch settling
	}


	public String getServletPath(){
		return servletPath;
	}
}