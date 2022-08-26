package com.edu.self.test;

import com.edu.self.service.EmployeeService;
//import com.edu.self.service.EmployeeServiceImpl;
import com.edu.self.util.MyDate;
import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체 생성
		EmployeeService service = new EmployeeService(5);
		//EmployeeServiceImpl service = EmployeeServiceImpl.getInstance();
		//service.EmployeeService();
		
		//2. method�� ���� ȣ��..
		System.out.println("============ 1. addManager ============ ");
		service.addManager(new Manager("고애신", new MyDate(1978, 1, 1), 20000.0, "기획부", 10));
		service.addManager(new Manager("최유진", new MyDate(1975, 2, 1), 34000.0, "개발부", 20));
		service.addManager(new Manager("김희성", new MyDate(1980, 3, 3), 20000.0, "영업부", 30));
		service.addManager(new Manager("이양화", new MyDate(1995, 8, 1), 37000.0, "기획부", 10));
		
		System.out.println("============ Manager 목록 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEngineer(new Engineer("채송화", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("김준완", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("이익준", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 목록 ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 2. deleteManager('최유진') ============ ");
		service.deleteManager("최유진");
		System.out.println("============ Manager 목록 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 3. updateManager(김희성 salary 200->350) ============ ");
		service.updateManager(35000.0, "영업부", 30, "김희성");//?
		System.out.println("============ Manager 목록 ============ ");
		service.printManagers();

		System.out.println("\n============ 4. findManager('고애신') ============ ");
		Manager retM1=service.findManager("고애신");
		System.out.println(retM1.getDetails());
		
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("부서번호가 10인 매니저 찾기");
		Manager[ ] retMs1 = service.findManager(10);
		for(Manager m : retMs1) {
			if(m==null) continue;
			System.out.println(m.getDetails());
		}
		
		System.out.println("\n============ 5. findEngineerMaxBonus ============ ");
		System.out.println(service.findEngineerMaxBonus());
		
		System.out.println("\n============ 6. getEngineerAnnualSalary('채송화') ============ ");
		System.out.println(service.getEngineerAnnualSalary("채송화"));
	}
}