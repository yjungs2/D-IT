package com.bank.busan;

public class Customer {
	public String name;
	public Account account;
	public String address;
	
	public void setCustomerInfo(String name, Account account, String address) {
		this.name = name;
		this.account = account;
		this.address = address;
	}
	
//	public void setAccount(Account account) {
//		this.account = account;
//	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getName() {
		return name;
	}
}
