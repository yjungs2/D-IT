package com.edu.child;
//Child Class
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{
	
	private String dept;
	/*
	 * Manager(){ ---> 자식생성자... 자식객체가 만들어진다.
	 * 자식이 만들어지기 위해서는 반드시 부모가 먼저 만들어져야 한다.
	 * 
	 * 자식생성자 {
	 * 첫라인에는 반드시 super() 이게 나온다... 부모를 생성하겠다는 코드
	 * 이왕 부모가 만들어질 거... 디폴트로 만들지 말고, 값을 우리가 넣어서 만들자.
	 * super(name, salary, birthday);
	 * +
	 * 자식만의 멤버는 this로 초기화해준다.
	 */

	public Manager(String name, double salary, MyDate birthday, String dept) {
		super(name, salary, birthday);
		this.dept = dept;
	}
	
	/*
		부모가 물려준 기능을 자식에게 맞게 다시 고쳐서 사용
		구현부를 수정한다. 선언부는 그대로 사용한다.
		-> 상속에서만 메소드에서 발생하는 성질...메소드 Overriding
		
		1) 부모가 물려준 기능을 그대로 받는다.
		2) 받아서 그걸 고친다.
	 */
	@Override
	public String getDetails() {
		return super.getDetails()+"\t"+dept;
	}
}
