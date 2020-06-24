package com.ejercicio7.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;

public class DB {
	
	private String jdbcURL;
	private String user;
	private String pass;
	private Connection conn;
	
	public DB() throws SQLException {
		this.jdbcURL = "jdbc:mysql://localhost:3306/tarea0?useSSL=false";
		this.user = "root";
		this.pass = "";
		this.conn = DriverManager.getConnection(this.jdbcURL, this.user, this.pass);
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void closeConnection() throws SQLException {
		this.conn.close();
	}
	
	public List<String> getTasks() throws SQLException {
		String query = "SELECT * FROM Task";
		Statement st = this.conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<String> data = new ArrayList<String>();
		while (rs.next()) {
			data.add(rs.getString("description"));
		}
		st.close();
		return data;
	}
	
	public void insertTask(String task) throws SQLException {
		Statement st = this.conn.createStatement();
		st.executeUpdate("INSERT INTO task (description) VALUES ('" + task +"')");
		st.close();		
	}
	
	public void deleteTask(String task) throws SQLException {
		Statement st = this.conn.createStatement();
		st.executeUpdate("DELETE FROM task WHERE description='" + task +"'");
		st.close();
	}
	
	public static void main(String args[]) throws SQLException {
		DB db = new DB();
		List<String> tasks = db.getTasks();
		
		for(String task: tasks) {
			System.out.println(task);
		}
		db.deleteTask("dormiiiiiiiiiiiiiiiirrr mucho2");
		db.closeConnection();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
