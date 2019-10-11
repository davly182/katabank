package com.dly.katabank;

import java.util.Date;

import com.dly.katabank.bean.Account;
import com.dly.katabank.bean.Operation;
import com.dly.katabank.bean.OperationType;
import com.dly.katabank.exception.DepositZeroException;
import com.dly.katabank.exception.NoAccountException;
import com.dly.katabank.exception.WithdrawalGreaterThanBalanceException;

public class ManageAccountFacade {
	Account account;
	
	public ManageAccountFacade(Account account) {
		this.account = account;
	}
	
	public void saveMoney(double money, Date depositDate) throws DepositZeroException, NoAccountException {
		if(account == null)
			throw new NoAccountException();
		if(money == 0)
			throw new DepositZeroException();

		account.AddOperation(new Operation(OperationType.DEPOSIT, depositDate, money, account.getBalance()));
		account.setBalance(account.getBalance() + money);
	}

	public void retrieveMoney(double money, Date withdrawalDate) throws WithdrawalGreaterThanBalanceException {
		if(money> account.getBalance())
			throw new WithdrawalGreaterThanBalanceException();

		account.AddOperation(new Operation(OperationType.WITHDRAWAL, withdrawalDate, money, account.getBalance()));
		account.setBalance(account.getBalance() - money);
	}


	
}
