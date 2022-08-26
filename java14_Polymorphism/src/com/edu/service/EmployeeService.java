package com.edu.service;

import com.edu.parent.Employee;

// Interface : 기능의 Template...표준화
public interface EmployeeService {
	public void manageEmployee(Employee e);
	int getAnnualSalary(Employee e);
	Employee findEmployee(Employee[ ] employee, String name);
	Employee[] findEmployee(Employee[ ] employees, String dept, String address);
}
