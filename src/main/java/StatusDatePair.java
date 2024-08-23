package main.java;

import java.util.Date;


public class StatusDatePair {

	private TransactionStatus status;
	private Date date;
	public StatusDatePair(TransactionStatus status, Date date) {
		super();
		this.status = status;
		this.date = date;
	}
	public TransactionStatus getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

}
