package com.edu.test;

import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.util.MyDate;
import com.edu.child.Engineer;

public class EmployeePolyTest1 {

	public static void main(String[] args) {
		Employee e = new Employee("구자경", 2000000, "역삼동",new MyDate(1999, 1, 3));
		Manager m =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Engineer eg = new Engineer("염창희", 3500000, "대연동", new MyDate(1999, 11, 14), "자바", 300);
		
		System.out.println(e.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		/////////////////////////////////////////////////////////////////////////
		/*
		 * PolyMorphism : 부모 타입으로 자식 객체를 생성하는 것
		   - Manager m = new Manager() (다형성 X)
		   - Employee m1 = new Manager() (다형성 O)
		   
		   Virtual Method Invocation 원리
		   compile type - 부모의 메소드 호출
		   Runtime Type - 생성된 실질적인 자식의 메소드를 호출
		 */
		System.out.println("\n===================================================\n");
		Employee m1 =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Employee eg1 = new Engineer("염창희", 3500000, "대연동", new MyDate(1999, 11, 14), "자바", 300);
		/*
		 * Object Casting
		- 부모 타입에 없는 자식만의 멤버를 호출할 때 발생
		- 자식 타입으로 Casting 하고 나서 자식의 타입으로 다시 찾아야 한다.
		 */
		((Manager) m1).changeDept("AI 분석부"); // 염미정의 dept를 변경
//		Manager manager = (Manager)m1;
//		manager.changeDept("AI 분석부");
		
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
	}
}


