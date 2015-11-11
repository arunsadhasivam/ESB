package com.message;

import java.io.Serializable;

public class Message implements Serializable {
	
	Message(){
		
	}
	Message(String result){
		this.result = result;
	}

	private String result;

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
}
