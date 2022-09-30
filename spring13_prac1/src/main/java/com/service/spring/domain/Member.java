package com.service.spring.domain;

public class Member {
	private String num;
	private String name;
	private String dept;
	
	public Member() {
	}
	public Member(String num, String name, String dept) {
		super();
		this.num = num;
		this.name = name;
		this.dept = dept;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", dept=" + dept + "]";
	}
}