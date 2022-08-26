package com.edu.array.service;

import com.edu.array.vo.Customer;
import com.edu.array.vo.Product;

public class ProductOutletService {
	// 1. 특정 고객이 구입한 상품을 리턴
	public Product[] getProducts(Customer cust) {
		return cust.getProducts();
	}
	
	// 2. 특정 고객이 구입한 상품의 maker들만 리턴
	public String[] getAllProductMaker(Customer cust) {
		String[] temp = new String[cust.getProducts().length]; // 객체 생성
		int idx = 0;
		Product[] pro = cust.getProducts();
		for(Product p: pro) {
			temp[idx++] = p.getMaker();
		}
		return temp;
	}
	
	// 3. 모든 고객들 중에서 특정한 고객을 검색하는 기능...주로 search, find로 시작
	public Customer findCustomerBySsn(Customer[] custs, int ssn) {
		Customer customer = null;
		for(Customer c : custs) {
			if(c.getSsn() == ssn)
				customer = c;
		}
		return customer;
	}
	
	// 4. 특정한 동네에 살고 있는 고객들을 검색
	public Customer[] findCustomerByAddress(Customer[] custs, String address) {
		Customer[] temp = new Customer[custs.length];
		int idx = 0;
		for(Customer c: custs) {
			if(c.getAddress().equals(address))
				temp[idx++] = c;
		}	
		return temp;
	}
	
	// 5. 특정 고객이 구입한 물건들 중에서 최고가에 해당하는 물건의 가격을 리턴
	public int getMaxPriceProduct(Customer cust) {
		int maxPrice = 0;
		Product[] pro = cust.getProducts();
		for(Product p: pro) {
			if(p.getPrice() > maxPrice)
				maxPrice = p.getPrice();
		}
		return maxPrice;
	}
	
	// 6. 특정 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴
	public Product[] getMorePriceProducts(Customer cust, int price) {
		Product[] temp = new Product[cust.getProducts().length];
		int idx = 0;
		Product[] pro = cust.getProducts();
		for(Product p: pro) {
			if(p.getPrice()>=price)
				temp[idx++] = p;
		}
		return temp;
	}
	
	// 7. 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴
	public Product[] getMorePriceProducts(Customer[] custs, int price) {
		int len = 0;
		int idx = 0;
		for(Customer c : custs) {
			len += c.getProducts().length;
		}
		Product[] temp = new Product[len];
		for(Customer c: custs) {
			Product[] pros = c.getProducts();
			for(Product p :pros) {
			if(p.getPrice()>=price)
				temp[idx++] = p;
			}
		}
		return temp;
	}
}
