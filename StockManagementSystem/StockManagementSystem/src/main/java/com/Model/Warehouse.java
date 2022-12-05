package com.Model;

public class Warehouse {
	private int warehouseID,managerID;
	private String loaction;
	
	
	public Warehouse(int warehouseID, int managerID, String loaction) {
		super();
		this.warehouseID = warehouseID;
		this.managerID = managerID;
		this.loaction = loaction;
	}


	public int getWarehouseID() {
		return warehouseID;
	}


	public int getManagerID() {
		return managerID;
	}


	public String getLoaction() {
		return loaction;
	}
	
	
	
	

}
