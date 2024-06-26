package com.in;
import java.util.*;



public class Transaction {
	
	private String transactionID ;
	private  long timestamp ;
	private  String transactionType ;
	private  double amount ;
	
	
	public Transaction(String transactionID, long timetamp,String transactionType,double amount)
	{
		this.transactionID =transactionID;
		this.timestamp= timetamp;
		this.transactionType=transactionType;
		this.amount=amount;
	}
	
	
	public String getTransactionID()
	{
		return transactionID;
	}
	
	public long getTimestamp()
	{
		return timestamp;
	}
	public String getTransactionType()
	{
		return transactionType;
	}
	public double getAmount()
	{
		return amount;
	}
	
	  @Override
	    public String toString() {
	        return "Transaction{" +
	                "transactionID='" + transactionID + '\'' +
	                ", timestamp=" + timestamp +
	                ", transactionType='" + transactionType + '\'' +
	                ", amount=" + amount +
	                '}';
	
	  }
}
