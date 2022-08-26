package com.edu.collection.test;

import java.util.ArrayList;
//import java.util.List;
/* 		List
 * 		 |
 * 	  ArrayList
 * 
 *  순서를 가지면서 중복은 허용
 */
public class ArrrayListTest3 {
	public static void main(String[] args) {
		// List<String> list = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("강호동");
		list.add("이수근");
		list.add("서장훈");
		list.add("김영철");
		list.add("이수근");
		
		System.out.println(list); // [강호동, 이수근, 서장훈, 김영철, 이수근]
		// 1. 3번째 사람을 삭제...누가 삭제되었는지 출력
		String removePerson1 = list.remove(2);
		System.out.println(removePerson1+"님이 삭제되셨습니다."); // 서장훈님이 삭제되셨습니다.
		System.out.println(list); // [강호동, 이수근, 김영철, 이수근]
		// 2. 가장 첫번째에 아이유를 추가
		list.add(0, "아이유");
		System.out.println(list); // [아이유, 강호동, 이수근, 김영철, 이수근]
		// 3. list에 저장된 사람들 중에서 김영철을 찾아서 김영철을 출력하세요.
		// for, get, equals() 사용
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("김영철"))
				System.out.println(list.get(i)); // 김영철
		}
		for(String name : list) {
			if(name.equals("김영철")) System.out.println(name); // 김영철
		}
	}
}