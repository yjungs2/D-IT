package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductDAO;
import com.service.spring.model.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public int insert(Product product) {
		return productDAO.insert(product);
	}

	@Override
	public int delete(List<String> list) {
		return productDAO.delete(list);
	}

	@Override
	public Product select(Product product) {
		return productDAO.select(product);
	}

	@Override
	public List<Product> select() {
		System.out.println("service select()...");
		return productDAO.select();
	}

	/*@Override
	public void update(Product product) {
		productDAO.update(product);
	}*/

	@Override
	public UserInfo select(UserInfo user) {
		System.out.println("service..."+user);
		return productDAO.select(user);
	}
	
	@Override
	public void logout() {
		//
	}

	/*@Override
	public void registerMember(UserInfo user) {
		productDAO.registerMember(user);
	}*/
}
