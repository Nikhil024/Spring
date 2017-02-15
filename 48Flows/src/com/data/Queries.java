package com.data;


public class Queries {

		public static String Create(String tablename,String values){
			return "INSERT INTO "+tablename+" values ("+values+")".toString();
		}
		
		public static String Delete(String tablename,String username,String password){
			return "DELETE FROM "+tablename+" WHERE USERNAME ='"+username+"' AND PASSWORD = '"+password+"'".toString();
		}
		
		public static String Updatepass(String tablename,String username,String password,String status){
			return "UPDATE "+tablename+" SET PASSWORD = '"+password+"',EVERIFIED ='"+status+"' WHERE USERNAME = '"+username+"'".toString();
		}
		
		public static String Update(String username,String dd){
			return "UPDATE USERS_FLOW_48 SET LASTLOGINDATE = '"+dd+"' WHERE USERNAME = '"+username+"'".toString();
		}
		public static String Updateemailverif(String email,String status){
			return "UPDATE USERS_FLOW_48 SET EVERIFIED ='"+status+"' where email = '"+email+"'".toString();
		}
		public static String Selectpass(String tablename,String username,String password){
			return "SELECT * FROM "+tablename+" WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'".toString();
		}
		
		public static String Select(String columns,String condition){
			return "SELECT "+columns+" FROM USERS_FLOW_48 WHERE "+condition+"".toString();
		}
}


/*class demo{
	public static void main(String args[]){
		System.out.println(Queries.Create("USERS", "'NIKHIL','PASSWORD','EMAIL'"));
		System.out.println(Queries.Delete("USERS", "NIKHIL", "PASSWORD"));
		System.out.println(Queries.Select("USERS", "NIKHIL", "PASSWORD"));
		System.out.println(Queries.Update("USERS", "NIKHIL", "PASSWORD"));
	}
}
*/