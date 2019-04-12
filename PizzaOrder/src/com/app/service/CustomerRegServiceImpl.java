package com.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LoginDao;
import com.app.pojos.Customer;

@Service
@Transactional

public class CustomerRegServiceImpl implements CustomerRegService {

	@Autowired
	private LoginDao dao;
	
	/*@Override
	public String registerCustomer(Customer c) {

		
		return dao.registerCustomer(c);
		
	}*/

}
