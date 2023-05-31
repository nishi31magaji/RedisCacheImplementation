package com.springbootmicroservices.rediscachedemo.exception;

public class InvoiceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3807734334112528940L;
	
	public InvoiceNotFoundException(String message) {
		super(message);
	}

}
