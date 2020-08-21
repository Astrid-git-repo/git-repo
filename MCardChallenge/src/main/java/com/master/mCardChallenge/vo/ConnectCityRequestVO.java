package com.master.mCardChallenge.vo;

import java.io.Serializable;

public class ConnectCityRequestVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String source;
	private String destination;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
