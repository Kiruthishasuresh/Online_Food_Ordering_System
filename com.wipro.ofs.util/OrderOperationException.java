package com.wipro.ofs.util;
public class OrderOperationException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public OrderOperationException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return message;}}
