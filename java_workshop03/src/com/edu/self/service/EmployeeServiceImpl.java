package com.edu.self.service;

import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeServiceIf{
	// 싱글톤
	private static EmployeeServiceImpl service = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {}
	public static EmployeeServiceImpl getInstance() {
		return service;
	}

	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;
	
	public void EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	@Override
	public void addManager(Manager m) {	
		ms[midx++] = m;
	}
	@Override
	public void addEngineer(Engineer eg) {
		egs[egidx++] = eg;
	}
	@Override
	public void deleteManager(String name) {
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(name)) {
				for(int j=i; j<midx; j++) {
					ms[j] = ms[j+1];
				}
				ms[midx] = null;
				midx--;
			}
		}
	}
	@Override
	public void deleteEngineer(String name) {
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				for(int j=i; j<egidx; j++) {
					egs[j] = egs[j+1];
				}
				egs[egidx] = null;
				egidx--;
			}
		}
	}
	@Override
	public void updateManager(double salary, String dept, int deptno, String name) {	
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getName().equals(name)) {
				manager.setSalary(salary);
				manager.setDept(dept);
				manager.setDeptno(deptno);				
			}			
		}
	}
	@Override
	public void updateEngineer(Engineer eg) {	
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(eg.getName())) {
				engineer.setBirthDate(eg.getBirthDate());
				engineer.setBonus(eg.getBonus());
				engineer.setSalary(eg.getSalary());
				engineer.setTech(eg.getTech());
			}
		}
	}	
	//Method Overloading
	@Override
	public Manager findManager(String name) {
		Manager m = null;
		for(Manager manager : ms) {
			if(manager==null) continue;			
			if(manager.getName().equals(name))
				m = manager;
		}
		return m;
	}
	@Override
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		int count = 0;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getDeptno()==deptno) {
				temp[count++] = manager;
			}
		}
		return temp;
	}
	@Override
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		
		return eg;
	}
	@Override
	public void printManagers() {		
		for(Manager m : ms) {
			if(m!=null)
			System.out.println(m.getDetails());
		}
	}
	@Override
	public void printEngineers() {
		for(Engineer e : egs) {
			if(e!=null)
			System.out.println(e.getDetails());
		}
	}
	@Override
	public String findEngineerMaxBonus() {
		double maxBonus = 0;
		String maxEngineer = "멤버";
		for(Engineer e : egs) {
			if(e==null) continue;
			if(maxBonus < e.getBonus())
				maxBonus = e.getBonus();
				maxEngineer = e.getName();
		}
		return maxEngineer+" : "+maxBonus;
	}
	@Override
	public double getEngineerAnnualSalary(String name) {
		double total = 0;
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				total += egs[i].getSalary()*12 + egs[i].getBonus();
			}
			else continue;
		}
		return total;
	}
}
