package com.edu.array.test;
import com.edu.array.vo.Product;
import com.edu.array.vo.Customer;
import com.edu.array.service.ProductOutletService;

public class ProductOutletServiceTest3 {
	public static void main(String[] args) {
		Product[] pros1 = { 
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "CJ"),
				new Product("삼다수", 8000, 10, "제주")
		};
		Product[] pros2 = { 
				new Product("안성탕면", 22000, 5, "농심"),
				new Product("칭따오", 500000, 50, "따오"),
				new Product("Terra", 22000, 3, "부산은행")
		};
		
		Customer[] custs = {
				new Customer(111, "구자경", "역삼동"),
				new Customer(222, "염미정", "산포시")
		};
		
		// 각각의 고객과 상품들을 Hashing...
		custs[0].buyProducts(pros2);
		custs[1].buyProducts(pros1);
		
		//
		ProductOutletService service = new ProductOutletService();
		
		///// 아래에서는 서비스의 기능을 하나씩 호출합니다. /////
		System.out.println(service.getProducts(custs[0]));
		System.out.println(service.getAllProductMaker(custs[0]));
		System.out.println(service.findCustomerBySsn(custs, 111));
		System.out.println(service.findCustomerByAddress(custs, "역삼동"));
		System.out.println(service.getMaxPriceProduct(custs[0]));
		System.out.println(service.getMorePriceProducts(custs[0], 20000));
		System.out.println(service.getMorePriceProducts(custs, 20000));
	}
}