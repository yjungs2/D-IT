package com.edu.test;
// static
class Car{
	int serialNumber; // field, 멤버 변수 -> heap
	static int counter;  // static V, class V, 전역변수 -> class area
	
	Car(){
		counter++;
		serialNumber = counter;
	}
}

public class StaticExamTest2 {
	public static void main(String[] args) {
		Car c1 = new Car(); // 로컬 변수 -> stack
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("=====field=====");
		System.out.println(c1.serialNumber); // 1
		System.out.println(c2.serialNumber); // 2
		System.out.println(c3.serialNumber); // 3
		System.out.println("=====static v=====");
		System.out.println(Car.counter); // 3
		System.out.println(c1.counter); // 3
		System.out.println(c2.counter); // 3
		System.out.println(c3.counter); // 3
	}
}
