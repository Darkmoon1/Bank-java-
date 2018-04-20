package yhy.study.Banking;

import java.io.Serializable;

public class Account implements Serializable{
	//�˻����
	protected double balance;
	public Account(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
	
	public double getBalance(){
		return balance;
	}
	//�����˻����
	public boolean deposit(double add){
		balance += add;
		return true;
	}
	//�����˻����
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
			throw new OverdraftException("�ʽ��㣬��͸֧���� Ӧ�۽��",sub);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GeneralAccount:" + this.balance;
	}
}
