package yhy.study.Banking;

import java.util.Iterator;

public class CustomerReport {
	 Bank bank;
	 Iterator<Customer> iterator;
	 public CustomerReport() {
		// TODO Auto-generated constructor stub
		 bank = Bank.getBank();
	}
	 
	 public void generateReport(){
		 iterator = bank.getCustomers();
		 while (iterator.hasNext()) {
			Customer next = (Customer)iterator.next(); 
			System.out.println(next.getLastName()+"  "+next.getFirstName());
			for(int i = 1;i<=next.getNumberOfAccount();i++){
				Account thisOne = next.getAccount(i);
				if (thisOne instanceof CheckingAccount) {
					thisOne = (CheckingAccount)thisOne;
					System.out.println("CheckingAccount"+i+":current balance is $"+thisOne.getBalance());
				}
				else if (thisOne instanceof SavingAccount) {
					thisOne = (SavingAccount)thisOne;
					System.out.println("SavingAccount"+i+":current balance is $"+thisOne.getBalance());
				}
				else {
					System.out.println("Account"+i+":current balance is $"+thisOne.getBalance());
				}
			}
				
		}
	 }
	
}
