package com.edu.broker.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.broker.exception.DuplicateException;
import com.edu.broker.exception.InvalidInputException;
import com.edu.broker.exception.NotFoundException;
import com.edu.broker.vo.Account;
import com.edu.broker.vo.Stock;

public interface BrokerDAO {
	
	// Account 관리
	void createAccount(Account acc) throws SQLException, DuplicateException;
	void deleteAccount(String ssn) throws SQLException, NotFoundException;
	void updateAccount(Account acc) throws SQLException, NotFoundException;
	
	// Trade 관리
	void createTrade(Account acc, Stock s) throws SQLException, DuplicateException ;
	void sellTrade(int tradeId, int quantity) throws SQLException, NotFoundException, InvalidInputException;
	void deleteTrade(int tradeId) throws SQLException, NotFoundException;
	void updateTrade(Stock s) throws SQLException, NotFoundException;
	
	// Apply
	Account findByAccount(String ssn) throws SQLException, NotFoundException;
	Stock findByStock(int stockId) throws SQLException, NotFoundException;
	ArrayList<Stock> findAllStock() throws SQLException;
}