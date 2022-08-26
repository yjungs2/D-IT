package com.edu.array.test;

import com.edu.array.vo.Product;

public class ProductArrayTest1 {
	public static void main(String[] args) {
		Product[] pros = { 
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "CJ"),
				new Product("삼다수", 8000, 10, "제주")
		};
		
		System.out.println("=======1. 상품 정보를 출력합니다.======");
		for(Product p : pros) System.out.println(p.getDetails());

		System.out.println("=======2. 상품의 maker를 출력합니다.======");
		for(Product p : pros) System.out.println(p.getMaker());
		
		System.out.println("=======3. 특정가격(1만원) 이상의 제품을 출력합니다.======");
		for(Product p : pros)
			if(p.getPrice()>=10000) System.out.println(p.getMaker()+", "+p.getPrice());
		
		System.out.println("=======4. 지금까지 구매한 상품의 총가격을 출력합니다.======");
		int total = 0;
		for(Product p : pros)
			total += p.getPrice() * p.getQuantity();
		
		System.out.println("Total Price :: "+total);
	}
}