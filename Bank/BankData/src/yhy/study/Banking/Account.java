package yhy.study.Banking;

import java.io.Serializable;

public class Account implements Serializable{
	//账户余额
	protected double balance;
	public Account(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
	
	public double getBalance(){
		return balance;
	}
	//增加账户余额
	public boolean deposit(double add){
		balance += add;
		return true;
	}
	//减少账户余额
//	public boolean withdraw(double sub){
//
//		if(balance>=sub){
//			balance -= sub;
//			return true;
//		}
//		else {
//			return false;
//		}
//		
//	}
	
	public void withdraw(double sub) throws OverdraftException {
		if(balance>=sub){
			balance -= sub;
		}
		else {
			throw new OverdraftException("资金不足，无透支保护 应扣金额",sub);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GeneralAccount:" + this.balance;
	}
}
