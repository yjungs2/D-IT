package com.edu.cons.test;

import com.edu.cons.Shirt;

public class ShirtTest {
	public static void main(String[] args) {
		Shirt t1 = new Shirt("nike", true, 'L');
//		Shirt t1;
//		t1 = new Shirt();
		System.out.println(t1.getBrand()+" "+t1.getSize()+" "+t1.isLongSleeved());
		
	}
}
