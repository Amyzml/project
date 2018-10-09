package com.zml.it;

public class AddException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AddException(){}
	
	public AddException(String message){
		super(message);
		
	}
	public AddException(Throwable th){
		super(th);
		
	}
	public AddException(String message,Throwable th){
		super(message,th);
	}
}
