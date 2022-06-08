package com.airline.exception;

public class AirlineServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 553660361034078298L;
	
	private String errorCode;
	
	public AirlineServiceException(String message) {
		super(message);
	}
	
	public AirlineServiceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}



	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
