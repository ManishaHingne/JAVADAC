package com.app.dao;

import java.util.List;

import com.app.pojos.Items;
import com.app.pojos.Pricing;

public interface MenuDao {
	List<Items> fetchCategoryByTypeCateg(String type, String Category);

	List<String> fetchCategoryByType(String type);

	List<String> fetchType();

	Items findItemById(int id);

	Pricing fetchItemsPriceById(int id);

	void open();

	void close();

}
