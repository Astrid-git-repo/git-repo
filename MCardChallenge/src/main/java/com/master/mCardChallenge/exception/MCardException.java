package com.master.mCardChallenge.exception;

public class MCardException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public MCardException(String error) {
		super(error);
		this.error = error;
	}
	
	

}
