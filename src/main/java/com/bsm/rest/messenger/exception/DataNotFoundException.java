package com.bsm.rest.messenger.exception;

public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6823759786738798031L;
	String message;

	public DataNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
