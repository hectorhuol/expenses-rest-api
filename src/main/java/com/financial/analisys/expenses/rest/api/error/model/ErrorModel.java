package com.financial.analisys.expenses.rest.api.error.model;

public class ErrorModel {

	private int statusCode;
	private String statusPhrase;
	private String message;
	private String errorURI;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorURI() {
		return errorURI;
	}

	public void setErrorURI(String error) {
		this.errorURI = error;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusPhrase() {
		return statusPhrase;
	}

	public void setStatusPhrase(String statusPhrase) {
		this.statusPhrase = statusPhrase;
	}
}
