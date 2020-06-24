package tarea0;

import java.sql.*;
public class JdbcConnectionDemo {
	
	public static void main(String args[]) {
		String JdbcURL = "jdbc:mysql://localhost:3306/ejercicio5?useSSL=false";
		String username = "root";
		String password = "";
		Connection conn = null;
		
		try {
	         //System.out.println("Connecting to database..............."+JdbcURL);
	         conn=DriverManager.getConnection(JdbcURL, username, password);
	         //System.out.println("Connection is successful!!!!!!");
	         
	         String query = "SELECT * from Estudents";
	         
	         Statement st = conn.createStatement();
	         
	         ResultSet rs = st.executeQuery(query);
	         
	         while (rs.next()) {
	        	 String name = rs.getString("firstname");
	        	 String lastname = rs.getString("lastname");
	        	 
	        	 System.out.println(name + " " + lastname);
	         }
	         st.close();
	         	
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         
	      }
	}

}
