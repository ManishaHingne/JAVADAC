package com.app.service;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MenuDao;
import com.app.dao.MenuDaoImpl;
import com.app.dao.OrderDao;
import com.app.dao.OrderDaoImpl;
import com.app.pojos.Customer;
import com.app.pojos.Items;
import com.app.pojos.Pricing;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	

	@Autowired
	MenuDao dao=new MenuDaoImpl();
	
	@Override
	public List<Items> fetchCategoryByTypeCateg(String type, String Category) {

		dao.open();
		List<Items>ls=dao.fetchCategoryByTypeCateg(type, Category);
		dao.close();
		return ls;
		
		
	}

	@Override
	public List<String> fetchCategoryByType(String type) {
		
		dao.open();
		
		List<String> ls= dao.fetchCategoryByType(type);
		dao.close();
		return ls;
		
	}

	@Override
	public List<String> fetchType() {
		dao.open();
		List<String> ls = dao.fetchType();
		dao.close();
		return ls;
	}

	@Override
	public Items findItemById(int id) {

		dao.open();
		Items items;
		items=dao.findItemById(id);
		dao.close();
		return items;
		
	}

	@Override
	public Pricing fetchItemsPriceById(int id) {

		dao.open();
		Pricing price =dao.fetchItemsPriceById(id);
		dao.close();
		return price;
	}

	
	
}
