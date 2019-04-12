package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LoginDao;
import com.app.dao.LoginDaoImpl;
import com.app.dao.OrderDao;
import com.app.dao.OrderDaoImpl;
import com.app.pojos.Customer;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	// LoginDao dao = new LoginDaoImpl();

	@Autowired
	LoginDao dao;

	@Override
	public String insertNewCustomer(Customer c) {
		/*
		 * dao.open(); Customer c1=new Customer(); c1= dao.insertNewCustomer(c);
		 * dao.close(); return c1;
		 */

		Integer id=dao.insertNewCustomer(c);
		if(id==null)
			return "User registratin failed";
		return "User registration successfull having user ID - "+id;

	}

	@Override
	public Customer fetchCustomerByEmailPass(String email, String password) {

		/*
		 * dao.open(); Customer cust1=new Customer(); cust1=
		 * dao.fetchCustomerByEmail(email); dao.close(); return cust1;
		 */

		return dao.fetchCustomerByEmailPass(email, password);

	}

}
