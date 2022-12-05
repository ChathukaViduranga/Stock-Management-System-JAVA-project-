package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class productDBUtil implements DBConnect {
	 
	
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
	
	public static ArrayList<Product> getProductDetails(int warehouseid){
		ArrayList<Product> productList = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs=null;

		
		//connection
				try {
					Connection con=getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="Select * from WarehouseProduct where WarehouseID='"+warehouseid+"'";
	    try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    while(rs.next()) {
	    	int pid=rs.getInt(1);
	    	String name=rs.getString(2);
	    	System.out.println(name);
	    	int wid=rs.getInt(3);
	    	int qua=rs.getInt(4);
	    	
	    	Product p= new Product(pid,name,wid,qua);
	    	productList.add(p);
	    	
	    	
	    }
	    }
	    catch (Exception e){
	    	System.out.println("Could not get data from warehouse databse");
	    }
		
		return productList;
	}
	
	public static boolean addProduct(int pid,String pname,int wid,int quantity) {
		
		Statement stmt = null;
		int rs=0;
		boolean validity=false;

		
		//connection
				try {
					Connection con= getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="insert into WarehouseProduct values('"+pid+"','"+pname+"','"+wid+"','"+quantity+"')";
	    try {
			rs=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(rs>0) {
	    	validity=true;
	    }
		
		return validity;
		
	}
	
	public static boolean updateProduct(int pid,int wid,int quantity) {
		
		Statement stmt = null;
		int rs=0;
		boolean validity=false;

		
		//connection
				try {
					Connection con= getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="UPDATE WarehouseProduct SET Quantity = '"+quantity+"' WHERE productID ='"+pid+"' and WarehouseID ='"+wid+"'";
	    try {
			rs=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(rs>0) {
	    	validity=true;
	    }
		
		return validity;
		
	}
	
        public static boolean deleteProduct(int pid,int wid) {
		
		Statement stmt = null;
		int rs=0;
		boolean validity=false;

		
		//connection
				try {
					Connection con= getConnection();
					stmt = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    String sql="DELETE FROM WarehouseProduct WHERE productID = '"+pid+"' and WarehouseID = '"+wid+"'";
	    try {
			rs=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(rs>0) {
	    	validity=true;
	    }
		
		return validity;
		
	}
	

}
