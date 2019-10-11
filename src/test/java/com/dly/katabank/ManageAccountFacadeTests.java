package com.dly.katabank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.dly.katabank.bean.Account;
import com.dly.katabank.bean.Operation;
import com.dly.katabank.bean.OperationType;
import com.dly.katabank.exception.DepositZeroException;
import com.dly.katabank.exception.NoAccountException;
import com.dly.katabank.exception.WithdrawalGreaterThanBalanceException;


public class ManageAccountFacadeTests {
	Account account;
	double money;


	@Before
	public void init() {
		this.account = new Account(5000);
	}

	/**
	 * US 1:
	 * In order to save money
	 * As a bank client
	 * I want to make a deposit in my account
	 * */

	/** US1.1
	 * @throws DepositZeroException 
	 * @throws NoAccountException 
	 * */
	@Test (expected = NoAccountException.class)
	public void makeDepositWithoutAccount() throws DepositZeroException, NoAccountException{
		money = 500 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(null);
		kataBankApplication.saveMoney(money, new Date());

	}

	/** US1.2
	 * @throws DepositZeroException 
	 * @throws NoAccountException 
	 * */
	@Test (expected = DepositZeroException.class)
	public void makeDepositAsWithNoMoney() throws DepositZeroException, NoAccountException{
		money = 0 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		kataBankApplication.saveMoney(money, new Date());

	}

	/** US1.3
	 * @throws DepositZeroException 
	 * @throws NoAccountException 
	 * */
	@Test 
	public void makeDepositWithAccountAndMoney() throws DepositZeroException, NoAccountException{
		money = 500 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		double balanceExpected = account.getBalance() + money; 
		kataBankApplication.saveMoney(money, new Date());
		assertEquals("Wrong account balance after deposit", balanceExpected, account.getBalance(), 0);
	}

	/**
	 * US 2:
	 * In order to retrieve some or all of my savings
	 *	As a bank client
	 *	I want to make a withdrawal from my account
	 */

	/** US2.1
	 * @throws WithdrawalGreaterThanBalanceException 
	 * */
	@Test (expected = WithdrawalGreaterThanBalanceException.class)
	public void makeWithdrawalWithNotEnoughMoney() throws WithdrawalGreaterThanBalanceException{
		money = 7500 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		kataBankApplication.retrieveMoney(money, new Date());
	}

	/** US2.2
	 * @throws WithdrawalGreaterThanBalanceException 
	 * */
	@Test 
	public void makeWithdrawalHalfBalance() throws WithdrawalGreaterThanBalanceException{
		money = 2500 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		kataBankApplication.retrieveMoney(money, new Date());
	}

	/** US2.3
	 * @throws WithdrawalGreaterThanBalanceException 
	 * */
	@Test 
	public void makeWithdrawalRetreiveAllMoney() throws WithdrawalGreaterThanBalanceException{
		money = 5000 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		kataBankApplication.retrieveMoney(money, new Date());
	}

	/**
	 * 	US 3:
	 *  In order to check my operations
	 *  As a bank client
	 *  I want to see the history (operation, date, amount, balance) of my operations
	 */

	/** US3.1
	 * @throws NoAccountException 
	 * @throws DepositZeroException 
	 * */
	@Test 
	public void getOperationsHistoryAfterDeposit() throws DepositZeroException, NoAccountException {
		money = 500 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		Date depositDate = new Date();
		Operation depositOperation = new Operation(OperationType.DEPOSIT, depositDate, money, account.getBalance());
		
		kataBankApplication.saveMoney(money, depositDate);
		//assertTrue("Wrong operation in history", account.getOperations().stream().anyMatch(depositOperation::equals));
		assertTrue("Wrong operation field in history", account.getOperations().contains(depositOperation));
		assertEquals("Wrong quantity of operations in history", 1, account.getOperations().size());
		account.printOperations();
	}
	
	/** US3.2
	 * @throws WithdrawalGreaterThanBalanceException 
	 * */
	@Test 
	public void getOperationsHistoryAfterWithdrawal() throws WithdrawalGreaterThanBalanceException {
		money = 1000 ;
		ManageAccountFacade kataBankApplication = new ManageAccountFacade(account);
		Date withdrawalDate = new Date();
		Operation withdrawalOperation = new Operation(OperationType.WITHDRAWAL, withdrawalDate, money, account.getBalance());
		
		kataBankApplication.retrieveMoney(money, withdrawalDate);
		assertTrue("Wrong operation field in history", account.getOperations().contains(withdrawalOperation));
		assertEquals("Wrong quantity of operations in history", 1, account.getOperations().size());
		account.printOperations();
	}




}
