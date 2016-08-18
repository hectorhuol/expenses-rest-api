package com.financial.analisys.expenses.rest.api.exceptions;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
		super();
	}
	
	public NoDataFoundException(Exception e) {
		super(e);
	}

	public NoDataFoundException(String message) {
		super(message);
	}

	public NoDataFoundException(String message, Exception e) {
		super(message, e);
	}

}
