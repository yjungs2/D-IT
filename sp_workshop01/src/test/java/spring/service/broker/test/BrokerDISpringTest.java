package spring.service.broker.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.broker.BrokerDatabase;
import spring.service.broker.impl.BrokerDatabaseImpl;
import spring.service.domain.Customer;
import spring.service.domain.Stock;

public class BrokerDISpringTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/brokerservice.xml");
		
		BrokerDatabase broker = (BrokerDatabase)factory.getBean("broker01");
		
		System.out.println("\n=============================================================================");
		Customer customer01 = (Customer)factory.getBean("customer01");
		System.out.println(customer01);
		
		System.out.println("\n=============================================================================");
		Customer customer02 = (Customer)factory.getBean("customer02");
		System.out.println(customer02);
		
		System.out.println("\n=============================================================================");
		Stock stock01 = (Stock)factory.getBean("stock01");
		System.out.println(stock01);
		
		System.out.println("\n=============================================================================");
		Stock stock02 = (Stock)factory.getBean("stock02");
		System.out.println(stock02);
		
		System.out.println("\n=============================================================================");
		broker.registerCustomer(customer01);
		broker.registerCustomer(customer02);
		broker.registerStock(stock01);
		broker.registerStock(stock02);
	}
}