package com.service.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.MyProduct;

@Service
public class MyProductServiceImpl implements MyProductService{

	@Autowired
	private MyProductDAO myProductDAO;
	
	@Override
	public void addProduct(MyProduct vo) throws Exception {
		myProductDAO.addProduct(vo);
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		return myProductDAO.findProductByName(name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		return myProductDAO.findProductByMaker(maker);
	}

	@Override
	public List<MyProduct> findProducts(String name) throws Exception {
		return myProductDAO.findProducts(name);
	}	
}