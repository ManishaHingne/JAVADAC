package com.app.service;

import com.app.pojos.Customer;

public interface LoginService {

	String insertNewCustomer(Customer c);

	Customer fetchCustomerByEmailPass(String email,String password);

}
