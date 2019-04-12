package com.app.service;

import java.util.List;

import javax.persistence.criteria.Order;

import com.app.pojos.Customer;
import com.app.pojos.Items;
import com.app.pojos.Pricing;

public interface MenuService {

	List<Items> fetchCategoryByTypeCateg(String type, String Category);

	List<String> fetchCategoryByType(String type);

	List<String> fetchType();

	Items findItemById(int id);

	Pricing fetchItemsPriceById(int id);
	
	

	
}
