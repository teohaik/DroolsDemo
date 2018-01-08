package drools;

public class Account {
	
	
	private long accountNumber;
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(long accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
	
	

}
