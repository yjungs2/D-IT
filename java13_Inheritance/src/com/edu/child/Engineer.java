package com.edu.child;
//Child Class
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee{
	
	private String tech;
	private double bonus;

	public Engineer(String name, double salary, MyDate birthday, String tech, double bonus) {
		super(name, salary, birthday);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()+"\t"+tech+"\t"+bonus;
	}
}
