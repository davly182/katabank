package com.dly.katabank.exception;

public class DepositZeroException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DepositZeroException () {
		super("Your deposit is 0");
	}
	
}
