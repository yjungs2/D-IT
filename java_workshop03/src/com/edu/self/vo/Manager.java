package com.edu.self.vo;

import com.edu.self.parent.Employee;
import com.edu.self.util.MyDate;

public class Manager extends Employee{
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptno;
	
	public Manager() {}
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name, birthDate, salary);
		this.dept = dept;
		this.deptno = deptno;
	}	
	public String getName() {
		return super.getName();
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	public double getSalary() {
		return super.getSalary();
	}
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDetails() {
		return super.getDetails()+","+dept+","+deptno;
	}
}