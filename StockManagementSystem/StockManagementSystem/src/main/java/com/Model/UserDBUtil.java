package com.Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//implements
public class UserDBUtil implements DBConnect{
	
	
	 public static Connection getConnection( ){
		 Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,dbusername, dbpasword);
		}
		catch(Exception e) {
			System.out.println("Could not connect to the database");
		}
		
		return con;
		
	}
	
	
	
	public static boolean validate(String username,String password) throws SQLException {
		boolean valid=false;
		Statement stmt = null;
		ResultSet rs=null;
		//connection
		try {
			Connection con= getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql="Select * from User where username='"+username+"' and password='"+password+"'";
		
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs.next()) {
			valid=true;
		}
		
		return valid;
	}
	
	
	public static ArrayList<User> getUser(String username){
		
		ArrayList<User> use= new ArrayList<>();
		Statement stmt = null;
		ResultSet rs=null;
		User u = null;
		
		//connection
				try {
					Connection con= getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="Select * from User where username='"+username+"'";
	    try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	if(rs.next()) {
	    		
	    int id= rs.getInt(1);
	    System.out.println(id);
		String fname = rs.getString(2);
		String lname = rs.getString(3);
		String contact = rs.getString(4);
		String address = rs.getString(5);
		String type = rs.getString(6);
		String uname = rs.getString(7);
		String pass = rs.getString(8);
		System.out.println("saved");
		 u = new User(id,fname,lname,contact,address,type,uname,pass);
		use.add(u);
		
		
		
		
	    	}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	   
	    
	    return use;
		
	}

}
