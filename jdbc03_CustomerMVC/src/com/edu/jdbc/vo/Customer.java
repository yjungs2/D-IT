package com.edu.jdbc.vo;

public class Customer {
	private int ssn;
	private String custName; // 필드명과 컬럼명이 다르다
	private String address;
	public static final String BASE_ADDR = "일광";
	public static final String BASE_NAME = "아무개";
	
	// Source > Generate Constructor using Fields...
	public Customer(int ssn, String custName, String address) {
		super();
		this.ssn = ssn;
		this.custName = custName;
		this.address = address;
	}

	public Customer(int ssn) {
		this(ssn, BASE_NAME, BASE_ADDR);
	}

	// Source > Generate Getters and Setters...
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return ssn+"\t"+custName+"\t"+address;
	}
}