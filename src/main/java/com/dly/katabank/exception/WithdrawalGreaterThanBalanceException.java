package com.dly.katabank.exception;

public class WithdrawalGreaterThanBalanceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public WithdrawalGreaterThanBalanceException() {
		super("Cannot make a withrdrawal greater than current balance");
	}
	

}
