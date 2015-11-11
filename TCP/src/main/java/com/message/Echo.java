package com.message;

public class Echo {

	
	public static Message getResult(String strMessage){
		Message message = new Message();
		message.setResult("hello:"+strMessage);
		return message;
	}
}
