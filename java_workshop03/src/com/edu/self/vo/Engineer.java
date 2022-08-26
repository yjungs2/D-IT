package com.edu.self.vo;

import com.edu.self.parent.Employee;
import com.edu.self.util.MyDate;

public class Engineer extends Employee{
	private String name;
	private MyDate birthDate;
	private double salary;
	private String tech;
	private double bonus;
	
	public Engineer() {}
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(name, birthDate, salary);
		this.tech = tech;
		this.bonus = bonus;
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
	public void setTech(String tech) {
		this.tech = tech;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}	
	public double getSalary() {
		return super.getSalary();
	}
	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	public String getDetails() {
		return super.getDetails()+","+tech+","+bonus;
	}	
}
