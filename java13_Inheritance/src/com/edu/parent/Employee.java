package com.edu.parent;
//Parent Class
import com.edu.util.MyDate;

public class Employee {
	private String name;
	private double salary;
	private MyDate birthday;
	
	// 생성자오버로딩 -> 0이나 null 값이 아닌 기본값으로 채워서 잘 동작하도록 함
	public static final double BASIC_SALARY = 100;
	public static final String BASE_NAME = "홍길동";
	
	public Employee() {} // 기본 생성자
	public Employee(String name, double salary, MyDate birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	} // this 쓰는 이유 : 멤버 변수와 로컬 변수의 이름이 같을 때 멤버 변수 앞에 사용
	// 생성자 앞에 붙은 this는 그 클래스 안에 있는 또 다른 생성자를 찾기 위함(호출)
	public Employee(String name, MyDate birthday) {
		this(name, BASIC_SALARY, birthday);
	}
	public Employee(double salary, MyDate birthday) {
		this(BASE_NAME, salary, birthday);
	}
	
	public String getDetails() {
		return name+"\t"+salary+"\t"+birthday;
	} //참조변수 birthday = birthday.toString()
}
