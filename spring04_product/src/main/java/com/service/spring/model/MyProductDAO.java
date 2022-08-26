package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.MyProduct;

public interface MyProductDAO {
	int addProduct(MyProduct vo) throws Exception;
	
	// 기능 추가
	List<MyProduct> findProductByName(String name) throws Exception;
	List<MyProduct> findProductByMaker(String maker) throws Exception;
	List<MyProduct> findProducts() throws Exception;
}