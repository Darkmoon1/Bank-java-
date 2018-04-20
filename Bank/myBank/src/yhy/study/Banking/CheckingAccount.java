package yhy.study.Banking;

public class CheckingAccount extends Account{
	
	public CheckingAccount(double balance,SavingAccount protectedBy) {
		// TODO Auto-generated constructor stub
		super(balance);
		this.protectedBy = protectedBy;
	}
//	double overdraftProtection;
	private SavingAccount protectedBy = null;
	@Override
//	public boolean withdraw(double sub) {
//		// TODO Auto-generated method stub
//		if (super.withdraw(sub)) {
//			return true;
//		}
//		else {
//			if (this.balance+ overdraftProtection - sub>=0) {
//				this.balance-=sub;
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//	}
	public void withdraw(double sub) throws OverdraftException{
		if (protectedBy!=null) {
			if (balance + protectedBy.getBalance() -sub >=0) {
				/*
				 * 超额由保护账户支付
				 */
				if (balance-sub<0) {
					protectedBy.withdraw(sub-balance);
					balance = 0;
				}
				else {
					balance -= sub;
				}
			}
			else {
				throw new OverdraftException("保护金额不足", sub);
			}
		}
		else{
			super.withdraw(sub);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CheckingAccount:"+this.balance + " " + this.protectedBy;
	}
	
}
