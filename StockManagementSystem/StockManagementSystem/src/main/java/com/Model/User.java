package com.Model;

public class User {
	private int userID;
	private String fname,lname,cNumber,address,type,username,password;
	
	
	public User(int userID, String fname, String lname, String cNumber, String address, String type, String username,String password) {
		
		this.userID = userID;
		this.fname = fname;
		this.lname = lname;
		this.cNumber = cNumber;
		this.address = address;
		this.type = type;
		this.username = username;
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getcNumber() {
		return cNumber;
	}


	public String getAddress() {
		return address;
	}


	public String getType() {
		return type;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	
	
	

}
