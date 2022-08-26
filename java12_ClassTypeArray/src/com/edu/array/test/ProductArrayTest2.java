package com.edu.array.test;
import com.edu.array.service.ProductService;
// Product + Service -> Test2
import com.edu.array.vo.Product;

public class ProductArrayTest2 {
	public static void main(String[] args) {
		Product[] pros = { 
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "CJ"),
				new Product("삼다수", 8000, 10, "제주")
		};
		
		ProductService service = new ProductService();
		// ProductService service = new ProductService(pros);
		// service라는 참조변수를 이용해서 구현하신 기능을 하나씩 호출합니다.
		
		// 1) 모든 상품들의 maker를 출력하는 기능
		service.printAllMaker(pros);
		// 2) 상품들의 총 금액을 리턴하는 기능
		System.out.println(service.getTotalPrice(pros)+"원");
		// 3) 특정 금액 이상의 상품들을 리턴하는 기능
		Product[] returnPros = service.getMorePrice(pros, 10000);
		for(Product p : returnPros) {
			if(p==null) continue;
			System.out.println(p.getMaker()+" "+p.getPrice());
		}
		// 4) 동일한 회사의 제품들만 리턴하는 기능
		Product[] returnPros1 = service.getCertainCompany(pros, "농심");
		for(Product p : returnPros1) {
			if(p==null) continue;
			System.out.println(p.getMaker()+" "+p.getCompany());
		}
		// 5) 구입한 상품들의 평균가를 리턴하는 기능 --- (quantity 포함)
		System.out.println(service.getAveragePrice(pros)+"원");
	}
}