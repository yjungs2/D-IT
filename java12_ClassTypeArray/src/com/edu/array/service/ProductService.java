package com.edu.array.service;

import com.edu.array.vo.Product;
// Product들을 핸들링하는 서비스 클래스.
// 기능들로만 구성되어져 있다.

public class ProductService { // identify 중요
	//	private Product[ ] pros;
	//	
	//	public ProductService(Product[] pros) {		
	//		this.pros = pros;
	//	}
	
	// 1) 모든 상품들의 maker를 출력하는 기능
	public void printAllMaker(Product[] pros) {
		System.out.println("1. 모든 제품들의 상품명입니다...");
		for(Product p : pros) System.out.println(p.getMaker());
	}
	// 2) 상품들의 총 금액을 리턴하는 기능
	public int getTotalPrice(Product[] pros) {
		System.out.println("2. 모든 제품들의 총 상품금액입니다...");
		int total = 0; // return 값 미리 선언
		for(Product p : pros) total += p.getPrice() * p.getQuantity();
		return total;
	}
	// 3) 특정 금액 이상의 상품들을 리턴하는 기능
	public Product[] getMorePrice(Product[] pros, int price) {
		System.out.println("3. 특정 가격 이상의 제품들입니다...");
		Product[] temp = new Product[pros.length]; // 임시 크기이므로 temp
		int index = 0;
		for(Product p : pros) {
			if(p.getPrice()>=price)
				temp[index++] = p;
		}
		return temp;
	}
	// 4) 동일한 회사의 제품들만 리턴하는 기능
	public Product[] getCertainCompany(Product[] pros, String company) {
		System.out.println("4. 동일한 회사의 제품들입니다...");
		Product[] temp = new Product[pros.length]; // 임시 크기이므로 temp
		int index = 0;
		for(Product p : pros) {
			if(p.getCompany().equals(company))
				temp[index++] = p;
		}
		return temp;
	}
	// 5) 구입한 상품들의 평균가를 리턴하는 기능 --- (quantity 포함)
	public int getAveragePrice(Product[] pros) {
		System.out.println("5. 구입한 제품들의 평균가입니다...");
		return getTotalPrice(pros)/pros.length;
	}
}