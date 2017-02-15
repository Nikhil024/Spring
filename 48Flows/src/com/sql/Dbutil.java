package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.data.CaesarCipher;
import com.data.PropertiesfileReading;
import com.data.Queries;

public class Dbutil {
	public static ResultSet Orcale(String Query) throws SQLException,ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		final String dbusername = PropertiesfileReading.getProperty("dbusername");
		final String dbpassword = PropertiesfileReading.getProperty("dbpassword");
		final String portnumber = PropertiesfileReading.getProperty("portnumber");
		final String dbname = PropertiesfileReading.getProperty("dbname");
		final String serverip = PropertiesfileReading.getProperty("serverip");
		
		
		//jdbc:oracle:thin:@localhost:1521:xe","nikhil","admin";
		String JdbcURL = "jdbc:oracle:thin:@"+serverip+":"+portnumber+":"+dbname;
		System.out.println(JdbcURL);
		   java.sql.Connection con = DriverManager.getConnection(JdbcURL,dbusername,dbpassword);
		   Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		   ResultSet rs = stmt.executeQuery(Query);
		   return rs;
	}

}


/*class nikhil
{
	public static void main(String args[]){
		try{
			ResultSet rs = Dbutil.Orcale(Queries.Select("users", CaesarCipher.encrypt("nikhil"), "admin"));
			if(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	
}
}*/