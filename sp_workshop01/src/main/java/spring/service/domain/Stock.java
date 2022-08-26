package spring.service.domain;

import java.io.Serializable;

public class Stock implements Serializable{
	// Field
	private String symbol;
	private double price;
	
	// Constructor
	public Stock() {
		System.out.println("\n::"+getClass().getName()+" 디폴트 생성자....");
	}
	public Stock(String symbol, double price) {
		System.out.println("\n::"+getClass().getName()+" symbol, price 인자 받는 생성자....");
		this.symbol = symbol;
		this.price = price;
	}
	
	// Method (Getters and Setters)
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		System.out.println("::"+getClass().getName()+".setSymbol()");
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		System.out.println("::"+getClass().getName()+".setPrice()");
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + "]";
	}
}