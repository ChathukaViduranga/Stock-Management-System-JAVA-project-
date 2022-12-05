package com.Model;

public class Product {
	private int productID,warehouseID,quantity;
	private String pname;
	public Product(int productID, String pname, int warehouseID, int quantity) {
		
		this.productID = productID;
		this.pname = pname;
		this.warehouseID = warehouseID;
		this.quantity = quantity;
	}
	public int getProductID() {
		return productID;
	}
	public int getWarehouseID() {
		return warehouseID;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getPname() {
		return pname;
	}
	

}
