package yhy.study.Banking;

import java.io.PrintWriter;
import java.util.Iterator;

public class CustomerReport {
	 Bank bank;
	 Iterator<Customer> iterator;
	 public CustomerReport() {
		// TODO Auto-generated constructor stub
		 bank = Bank.getBank();
	}
	 /**
	  * bank类被架空 没有实际作用
	  * @param pWriter
	  */
	 public void generateReport(PrintWriter pWriter){
		 iterator = Mysql.getCustomers().iterator();
		 pWriter.print("----------------------------------------银行报告-------------------------------------<br/>");
		 while (iterator.hasNext()) {
			Customer next = (Customer)iterator.next(); 
			pWriter.println(next.getLastName()+"  "+next.getFirstName()+"<br/>");
			for(int i = 1;i<=next.getNumberOfAccount();i++){
				Account thisOne = next.getAccount(i);
				if (thisOne instanceof CheckingAccount) {
					thisOne = (CheckingAccount)thisOne;
					pWriter.println("CheckingAccount"+i+":current balance is $"+thisOne.getBalance()+"<br/>");
				}
				else if (thisOne instanceof SavingAccount) {
					thisOne = (SavingAccount)thisOne;
					pWriter.println("SavingAccount"+i+":current balance is $"+thisOne.getBalance()+"<br/>");
				}
				else {
					pWriter.println("Account"+i+":current balance is $"+thisOne.getBalance()+"<br/>");
				}
			}
			pWriter.print("---------------------------------------------------------------------------------<br/>");
				
		}
	 }
	
}
