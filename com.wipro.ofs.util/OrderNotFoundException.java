package com.wipro.ofs.util;
public class OrderNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String orderfound;
	public OrderNotFoundException(String orderfound) {
		this.orderfound=orderfound;
	}
	@Override
	public String toString() {
		return orderfound;
	}

}
