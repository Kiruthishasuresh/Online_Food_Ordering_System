package com.wipro.ofs.entity;
public class MenuItem {
	private String itemId;
	private String itemName;
	private double price;
	private int stock;
	
	public MenuItem(String itemId, String itemName, double price, int stock) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}
	public String getItemid() {
		return itemId;
	}
	public void setItemid(String itemid) {
		this.itemId = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}}

