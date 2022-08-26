package com.edu.service;

import com.edu.parent.Employee;
import com.edu.child.Engineer;

/*
 * Employee의 자식 클래스인
	Manager, Engineer, Secretary 객체들을 핸들링하는 기능만으로 이뤄진 Service 클래스...
				Employee
				   |
	Manager    Engineer    Secretary
	
1step....가장 저차원적으로 위 구조를 핸들링할때 사용하는 메소드 기법
         method identifier의 일관성이 없다. 가독력 급격히 떨어짐.
:: 추가에 관련된 기능을 정의하는 경우
public void addManager(Manager m){ // }
public void insertEngieer(Engineer eg){ // }
public void manageSec(Secretary sc){ // }

2step ....1단계 보다는 조금 나은 정의....나름의 일관성이 있다.
public void addManager(Manager m){ // }
public void addEngineer(Engineer eg){ // }
public void addSecretary(Secretary sc){ // }

3step ....2단계와 비슷하지만 훨씬더 일관성과 가독성을 높인다
               메소드 오버로딩 기법 사용. 하지만 여전히 메소드의 갯수를 줄이지는 못한다.
public void addEmployee(Manager m){ // }
public void addEmployee(Engineer eg){ // }
public void addEmployee(Secretary sc){ // }

4step.....3단계와 같은 역할을 하지만 단 1번만 정의하면 된다. -> Polymorphism
          instanceof 키워드의 중요성
public void addEmployee(Employee e){
if(e instanceof Manager){

}
if(e instanceof Engineer){

}
if(e instanceof Secretary){

}
*/
public class EmployeePolyService {
	public void manageEmployee(Employee e) {
		System.out.println(e.getDetails());
	}
	
	// 부모 타입의 변수 e에 할당된 객체가 어떤 타입의 자식인지를 알아내야 한다.
	// Manager, Engineer, Secretary인지...
	// 실질적으로 생성된 객체 타입을 알아내는 연산자는 instanceof
	public int getAnnualSalary(Employee e) {
		int total = 0;
		if(e instanceof Engineer)
			total += e.getSalary()*12 + ((Engineer) e).getBonus();
		else
			total += e.getSalary()*12;
		return total;
	}
	
	public Employee findEmployee(Employee[ ] employee, String name) {
		Employee find = null;
		
		return find;
	}
	
	public Employee[] findEmployee(Employee[ ] employee, String dept, String address) {
		Employee[] temp = new Employee[employee.length];
		
		return temp;
	}
}
