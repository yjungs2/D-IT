package com.edu.self.parent;

import com.edu.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
	public static final double BASIC_SALARY = 300000.0;
	
	public Employee() {}
	public Employee(String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public Employee(String name, MyDate birthDate) {
		this(name, birthDate, BASIC_SALARY);
	}

	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String getDetails() {
		return name+","+birthDate+","+salary;
	}	
}
