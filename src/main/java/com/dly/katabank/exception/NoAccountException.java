package com.dly.katabank.exception;

public class NoAccountException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoAccountException () {
		super("There is no account");
	}
	
}