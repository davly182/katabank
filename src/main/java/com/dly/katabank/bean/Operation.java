package com.dly.katabank.bean;

import java.util.Date;

public class Operation {
	private OperationType operationType;
	private Date operationDate;
	private double operationAmount;
	private double balanceBeforeOperation;

	public Operation(OperationType operationType, Date operationDate, double operationAmount, double balanceBeforeOperation) {
		this.operationType = operationType;
		this.operationDate = operationDate;
		this.operationAmount = operationAmount;
		this.balanceBeforeOperation = balanceBeforeOperation;

	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public double getOperationAmount() {
		return operationAmount;
	}

	public void setOperationAmount(double operationAmount) {
		this.operationAmount = operationAmount;
	}

	public double getBalanceBeforeOperation() {
		return balanceBeforeOperation;
	}

	public void setBalanceBeforeOperation(double balanceBeforeOperation) {
		this.balanceBeforeOperation = balanceBeforeOperation;
	}

	@Override
	public String toString() {
		return operationType + " " + operationDate + " " + operationAmount + " " + balanceBeforeOperation ;
	}
	
	@Override
	public boolean equals(Object newOperation) {
		Operation operation = (Operation) newOperation;
		return operationType == operation.operationType
				&& operationDate.equals(operation.operationDate)
				&& operationAmount == operation.operationAmount
				&& balanceBeforeOperation == operation.balanceBeforeOperation;
	}
	

}
