package com.master.mCardChallenge.exception;

public class MCardFileException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public MCardFileException(String error) {
		super();
		this.error = error;
	}
	
	



}
