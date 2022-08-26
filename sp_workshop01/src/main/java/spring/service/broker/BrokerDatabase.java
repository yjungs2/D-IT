package spring.service.broker;

import spring.service.domain.Customer;
import spring.service.domain.Stock;

public interface BrokerDatabase {
	void registerCustomer(Customer customer);
	void registerStock(Stock stock);
	Customer getAllCustomer();
	Stock getAllStock();
}