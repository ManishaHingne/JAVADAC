package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface LoginDao {

	// String registerCustomer(Customer c);
	// Customer getCustomer(String email);

//	void open();

	//void close();

	Integer insertNewCustomer(Customer c);

	Customer fetchCustomerByEmailPass(String email,String password);

}
