package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Car;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.CarDAO;
import com.service.spring.model.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarDAO carDAO;

	@Override
	public int insert(Car car) {
		return carDAO.insert(car);
	}

	@Override
	public int delete(List<String> list) {
		return carDAO.delete(list);
	}

	@Override
	public Car select(Car car) {
		return carDAO.select(car);
	}

	@Override
	public List<Car> select() {
		System.out.println("service select()...");
		return carDAO.select();
	}

	@Override
	public void update(Car car) {
		carDAO.update(car);
	}

	@Override
	public UserInfo select(UserInfo user) {
		System.out.println("service..."+user);
		return carDAO.select(user);
	}
	
	@Override
	public void logout() {
		//
	}

	@Override
	public void registerMember(UserInfo user) {
		carDAO.registerMember(user);
	}
}
