package com.edu.broker.vo;

public class Account {
	private String ssn;
	private String name;
	private String address;
	
	public Account(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Account [ssn=" + ssn + ", name=" + name + ", address=" + address + "]";
	}
	
}
