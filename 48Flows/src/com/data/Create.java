package com.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sql.Dbutil;
public class Create {
	public static void createmethod(String query){
		try{
			ResultSet rs = Dbutil.Orcale(query);
		if(rs.next()){
			String username = rs.getString(2);
			String password = rs.getString(3);
			String email = rs.getString(4);
			String lastlogin = rs.getString(5);
			}
		else{
			System.out.println("Not able to ");
			
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}