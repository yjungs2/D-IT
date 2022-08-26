package spring.service.broker.impl;

import spring.service.broker.BrokerDatabase;
import spring.service.domain.Customer;
import spring.service.domain.Stock;

public class BrokerDatabaseImpl implements BrokerDatabase{
	private Customer customer;
	private Stock stock;
	
	@Override
	public void registerCustomer(Customer customer) {
		System.out.println(customer+"님 고객 등록 성공");
	}

	@Override
	public void registerStock(Stock stock) {
		System.out.println(stock+"주식 등록 성공");
	}

	@Override
	public Customer getAllCustomer() {
		return customer;
	}

	@Override
	public Stock getAllStock() {
		return stock;
	}
}