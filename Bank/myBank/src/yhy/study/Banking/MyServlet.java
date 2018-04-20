package yhy.study.Banking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String GA = req.getParameter("GA");
		String SA = req.getParameter("SA");
		String CA = req.getParameter("CA");
		Mysql.getConn();
		Customer customer = new Customer(fname, lname);
		customer.addAccount(new Account(Double.parseDouble(GA)));
		SavingAccount savingAccount = new SavingAccount(Double.parseDouble(SA), 0.01);
		customer.addAccount(savingAccount);
		customer.addAccount(new CheckingAccount(Double.parseDouble(CA), savingAccount));
		Mysql.addCustomer(customer);
		Mysql.sqlClose();
		
		PrintWriter pWriter = resp.getWriter();
		pWriter.println("×¢²á³É¹¦");
		return;
		
	}		

}
