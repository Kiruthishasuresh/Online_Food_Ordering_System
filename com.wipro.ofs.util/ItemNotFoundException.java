
package com.wipro.ofs.util;
public class ItemNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String stock_status;
	
	public ItemNotFoundException(String stock_status) {
		this.stock_status = stock_status;
	}
	@Override
	public String toString() {
		return stock_status;};}
