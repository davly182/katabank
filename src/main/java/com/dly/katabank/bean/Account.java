package com.dly.katabank.bean;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private double balance;
	private List<Operation> operations = new ArrayList<Operation>();
	
	public Account(double balance){
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}
	
	public void AddOperation(Operation operation) {
		this.operations.add(operation);
	}

	public void printOperations() {
		operations.stream().forEach(System.out::println);
	}
	
	
}
