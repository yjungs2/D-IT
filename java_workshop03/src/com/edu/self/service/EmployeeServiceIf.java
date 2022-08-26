package com.edu.self.service;

import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

// Interface : 표준화
public interface EmployeeServiceIf {
	public void addManager(Manager m);
	public void addEngineer(Engineer eg);
	public void deleteManager(String name);
	public void deleteEngineer(String name);
	public void updateManager(double salary, String dept, int deptno, String name);
	public void updateEngineer(Engineer eg);
	public Manager findManager(String name);
	public Manager[ ] findManager(int deptno);
	public Engineer findEngineer(String name);
	public void printManagers();
	public void printEngineers();
	public String findEngineerMaxBonus();
	public double getEngineerAnnualSalary(String name);
}
