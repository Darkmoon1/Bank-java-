package yhy.study.Banking;

public class SavingAccount extends Account{
	
	public SavingAccount(double balance,double interesRate) {
		super(balance);
		// TODO Auto-generated constructor stub
		this.interesRate = interesRate;
	}

	double interesRate;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SavingAccount:"+this.balance + " " + this.interesRate;
	}
}