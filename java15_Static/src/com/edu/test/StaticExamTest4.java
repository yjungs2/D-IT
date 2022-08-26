package com.edu.test;
// static
// 6. 싱글톤(Singtone)
class Service{
	private static Service service = new Service(); // 하나의 객체 생성
	private Service() { // private 생성자()
		System.out.println("Singtone Pattern Ready");
	}
	public static Service getInstance() { // static 중요
		return service;
	}
}
public class StaticExamTest4 {
	public static void main(String[] args) {
//		Service s1 = new Service(); // 객체 생성 불가
		Service service1 = Service.getInstance();
		Service service2 = Service.getInstance();
		Service service3 = Service.getInstance();
		System.out.println(service1); // com.edu.test.Service@7852e922
		System.out.println(service2); // 같은 결과
		System.out.println(service3); // 같은 결과
	}
}
