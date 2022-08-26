package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
//import com.edu.service.EmployeePolyService;
import com.edu.service.EmployeeServiceImpl;
import com.edu.util.MyDate;

public class EmployeeServiceTest3 {
	public static void main(String[] args) {
		Employee[] emps = {
				new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부"),
				new Engineer("염창희", 3500000, "대연동", new MyDate(1999, 11, 14), "자바",300),
				new Secretary("홍길동", 2520000, "NY", new MyDate(1982, 4, 2), "James"),
				new Manager("염미정2", 2100000, "문현동2", new MyDate(2000, 2, 12), "개발부2")
		};
		
		//EmployeePolyService service = new EmployeePolyService();
		EmployeeServiceImpl service = EmployeeServiceImpl.getInstance();
		service.manageEmployee(emps[1]);
		
		System.out.println(service.getAnnualSalary(emps[1])); //엔지니어...보너스
	}
}