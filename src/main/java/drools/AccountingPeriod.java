package drools;

import java.util.Date;

public class AccountingPeriod {
	
	private Date startDate;
	private Date endDate;
	
	public AccountingPeriod() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AccountingPeriod(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	

	
}
