package spring.service.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	// Field
	private String ssn;
	private String custName;
	private String address;
	
	// Constructor
	public Customer() {
		System.out.println("\n::"+getClass().getName()+" 디폴트 생성자");
	}
	public Customer(String custName, String address) {
		System.out.println("\n::"+getClass().getName()+" custName, address 인자 받는 생성자");
		this.custName = custName;
		this.address = address;
	}
	public Customer(String ssn, String custName, String address) {
		System.out.println("\n::"+getClass().getName()+" ssn, custName, address 인자 받는 생성자");
		this.ssn = ssn;
		this.custName = custName;
		this.address = address;
	}
	
	// Method (Getters and Setters)
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		System.out.println("::"+getClass().getName()+".setSsn()");
		this.ssn = ssn;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		System.out.println("::"+getClass().getName()+".setCustName()");
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		System.out.println("::"+getClass().getName()+".setAddress()");
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", custName=" + custName + ", address=" + address + "]";
	}
}