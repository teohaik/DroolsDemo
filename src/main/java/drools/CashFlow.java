package drools;

import java.util.Date;

public class CashFlow {
	
	private Date mvtDate;		
	private double amount;
	private int type;
	private long accountNumber;
	
	public CashFlow() {}

	public Date getMvtDate() {
		return mvtDate;
	}

	public void setMvtDate(Date mvtDate) {
		this.mvtDate = mvtDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
