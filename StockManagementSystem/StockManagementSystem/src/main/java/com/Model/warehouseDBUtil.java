package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class warehouseDBUtil implements DBConnect {
	
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
	
	public static Warehouse getWarehouse(int managerid){
		
		
		
		Statement stmt = null;
		ResultSet rs=null;
		Warehouse w = null;
		
		//connection
				try {
					Connection con= getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="Select * from Warehouse where managerID='"+managerid+"'";
	    try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    if(rs.next()) {
	    	int wid=rs.getInt(1);
	    	System.out.println("Warehouse id is"+wid);
	    	int mid=rs.getInt(2);
	    	String location= rs.getString(3);
	    	w=new Warehouse(wid,mid,location);
	    	
	    	
	    }
	    }
	    catch (Exception e){
	    	System.out.println("Could not get data from warehouse databse");
	    }
	    
	    return w;
		
	}

}
