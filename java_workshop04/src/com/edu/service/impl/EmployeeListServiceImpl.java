package com.edu.service.impl;
/*
 * VO클래스들을 핸들링하는 기능들만 모아놓은 서비스 클래스
 * 서비스 인터페이스를 상속받아서 작성했다.
 * 
 * 이런 서비스 클래스는 클라이언트에서 요청이 아무리 많이 들어와도
 * 클래스 인스턴스는 단 하나 서버상에 만들어놓고
 * 요청을 처리하는 것은 서비스 클래스에 메소드가 요청을 받아서 처리한다.
 * 즉 Singletone Pattern으로 작성
 * 
 * 해당 서비스 클래스는 이후 JDBC기술에서 Database 어플리케이션이 될 것이다.
 * 
 * 싱글톤 작성 패턴
 * 1. private static 객체를 일단 하나 생성
 * 2. private 생성자..다른곳에서 생성을 하지 못하도록 막아둔다
 * 3. public static 생성한 객체를 받아 쓸수 있도록 열어둔다
 */
import java.util.ArrayList;

import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService{
	
	//추가
	private ArrayList<Employee> list;
	
	//싱글톤 추가
	private static EmployeeListServiceImpl service = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() {
		list = new ArrayList<>();
	}
	public static EmployeeListServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void addEmployee(Employee e) {	
		//list에 추가하도록 로직을 작성...있으면 추가되지 않도록 제어를 해야 한다
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(e.getEmpId())) { // 추가하려는 직원이 이미 있다면
				find = true;
				System.out.println(e.getName()+"님은 이미 직원으로 등록되어 있습니다.");
				return;
			} // if
		} // for
		if(find == false) { // 추가하려는 직원이 없다면
			list.add(e);
			System.out.println(e.getName()+"님을 직원으로 등록했습니다.");
		} // if
	}
	@Override
	public void deleteEmployee(String empId) { // list에서 삭제
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(empId)) { // 삭제하려는 직원이 이미 있다면
				find = true;
				System.out.println(emp.getName()+"님을 퇴사처리 하겠습니다.");
				list.remove(emp);
				break;
			} // if
		} // for
		if(find == false) System.out.println("삭제하려는 직원이 존재하지 않습니다.");
	}
	// id는 수정의 대상이 안 된다. (고유한 값)
	// id를제외한 나머지 필드값이 수정의 대상이 된다.
	@Override
	public void updateEmployee(Employee e) { //list에서 수정
		boolean find = false;
		for(Employee emp : list) {
			if(emp.getEmpId().equals(e.getEmpId())) { // 수정 대상이 존재한다면
				emp.setName(e.getName());
				emp.setAddr(e.getAddr());
				emp.setAddr(e.getAddr());
				emp.setSalary(e.getSalary());
				if(emp instanceof Manager) {
					((Manager) emp).changeDept(((Manager) e).getDept());
				}
				if(emp instanceof Engineer) {
					((Engineer) emp).changeTech(((Engineer) e).getTech());
					((Engineer) emp).changeBonus(((Engineer) e).getBonus());
				}
			} // if
		} // for
	}//updateEmployee
	@Override
	public ArrayList<Employee> findEmployees(String addr) { //list에서 검색
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for(Employee emp : list) {
			if(emp.getAddr().equals(addr)) temp.add(emp);
		}
		return temp;
	}
	@Override
	public void findEmployees() {
		//list에 있는 데이타들을 콘솔로 출력
		for(Employee emp : list) System.out.println(emp);
	}
}