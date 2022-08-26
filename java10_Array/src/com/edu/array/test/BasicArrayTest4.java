package com.edu.array.test;
/*
 * 배열의 특징
 * 1. Same DataType이 전제이다.
 * 2. 클래스타입이 제공되지 않는다.
 * 3. 배열은 Resizing이 안 된다.
 *    사이즈를 변경하려면 새로운 객체가 생성되고 이전의 객체는 GC의 대상이 된다.
 * 4. 사이즈가 다른 배열의 내용을 copy해올 수는 있다.
 *    이때 System.arraycopy()를 사용한다.
 */
public class BasicArrayTest4 {
	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4, 5, 6}; // size 6
		int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // size 10

		//System.arraycopy()
		for(int i : target) System.out.println(i+" "); // 8, 7, 6, 5, 4, 3
	}
}
