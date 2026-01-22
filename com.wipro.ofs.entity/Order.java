package com.wipro.ofs.entity;
public class Order {
	 private String orderId ; 
	 private String userId ;
	 private double totalAmount ;
	 public Order(String orderId, String userId, double totalAmount) {
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
	}
	 public String getOrderId() {
		return orderId;
	}
	 public void setOrderId(String orderId) {
		 this.orderId = orderId;
	 }
	 public String getUserId() {
		 return userId;
	 }
	 public void setUserId(String userId) {
		 this.userId = userId;
	 }
	 public double getTotalAmount() {
		 return totalAmount;
	 }
	 public void setTotalAmount(double totalAmount) {
		 this.totalAmount = totalAmount;
	 }
	

}
