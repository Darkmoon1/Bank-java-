package yhy.study.Banking;

import java.io.Serializable;
import java.util.*;
/**
 * 实现序列化接口
 * @author 86427
 *
 */
public class Customer implements Serializable{
	private String firstName;
	private String lastName;
	private SavingAccount savingAccount;
	private CheckingAccount checkingAccount;
	private List<Account> accounts;
	/*
	 * 构造方法
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accounts = new ArrayList<Account>();
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer:"+this.firstName+" "+this.lastName+" "+this.savingAccount + " " + this.checkingAccount;
	}
	
	/*
	 * get and set
	 */
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Account getAccount(int index) {
		/*
		 * 从1开始
		 */
		return accounts.get(index-1);
	}
	
	public int getNumberOfAccount(){
		return accounts.size();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}

	public double getSaving() {
		return savingAccount.getBalance();
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public double getChecking() {
		return checkingAccount.getBalance();
	}

	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	
	
	
	
}
