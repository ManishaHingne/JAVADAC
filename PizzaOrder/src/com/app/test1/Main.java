package com.app.test1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.dao.LoginDaoImpl;
import com.app.dao.MenuDao;
import com.app.dao.MenuDaoImpl;
import com.app.dao.OrderDao;
import com.app.dao.OrderDaoImpl;
import com.app.pojos.Customer;
import com.app.pojos.Items;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Pricing;
import com.app.service.LoginService;
import com.app.service.LoginServiceImpl;
import com.app.service.MenuService;
import com.app.service.MenuServiceImpl;
import com.app.service.OrderService;
import com.app.service.OrderServiceImpl;

public class Main {

/*	// fetch by types
	public List<String> fetchType() {

		MenuDaoImpl mdao = new MenuDaoImpl();
		List<String> list = null;
		try {

			mdao.open();
			list = mdao.fetchType();
			for (String type : list) {
				System.out.println(type);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			mdao.close();
		}
		return list;
	}

	// Fetch sub category //
	public List<String> fetchCategoryByType(String type) {

		MenuDaoImpl mdao = new MenuDaoImpl();
		List<String> veglist = null;
		List<String> nonveglist = null;
		try {

			mdao.open();
			veglist = mdao.fetchCategoryByType("VEG");
			for (String type1 : veglist) {
				System.out.println(type);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.close();
		}
		return veglist;

	}

	// fetch item with type and subtype

	public List<Items> getItems(String type, String category) {

		MenuDaoImpl mdao = new MenuDaoImpl();
		List<Items> list = null;
		try {
			mdao.open();

			list = mdao.getItems("Veg", "Simply Veg");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.close();
		}

		return list;
	}

	// Find item by id
	public Items findItemById(int id) {

		MenuDaoImpl mdao = new MenuDaoImpl();
		Items items = new Items();
		try {
			mdao.open();
			items = mdao.findItemById(id);
			if (items != null)
				System.out.println(items);
			else
				System.out.println("Item not found");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.close();
		}
		return items;

	}

	// Insert new customer
	public Customer insertNewCustomer(Customer c) {

		Customer c1 = new Customer();
		LoginDaoImpl ldao = new LoginDaoImpl();
		try {
			ldao.open();
			c1 = new Customer(5, "Kolhapur", "Amit@gmail.com", "9890652427", "Amit", "Amit123");
			System.out.println(c1);
			ldao.insertNewCustomer(c1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ldao.close();
		}
		return c1;

	}

	// fetch by email
	public Customer fetchCustomerByEmail(String email) {

		LoginDaoImpl ldao = new LoginDaoImpl();
		Customer c = new Customer();
		try {
			ldao.open();
			c = ldao.fetchCustomerByEmail(email);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ldao.close();
		}
		return c;
	}

	// fetch item by priceid
	public List<Pricing> fetchItemsPriceById(int id) {

		MenuDaoImpl mdao = new MenuDaoImpl();
		List<Pricing> list = null;

		try {

			mdao.open();
			list = mdao.fetchItemsPriceById(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mdao.close();
		}

		return list;
	}

	// Insert order
	public Orders insertOrder(Orders order) {

		OrderDaoImpl odao = new OrderDaoImpl();
		Orders orders = new Orders();
		try {

			odao.open();

			orders = odao.insertOrder(order);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			odao.close();
		}

		return orders;

	}

	// fetch order by status
	public List<Orders> fetchOrderStatus(String status) {

		//OrderDaoImpl odao = new OrderDaoImpl();
		OrderService odao=new OrderServiceImpl();
		List<Orders> ls = null;

		try {
			odao.open();

			ls=odao.fetchOrderStatus(status);
			
			 for (Orders or : ls) {
			 System.out.println(or.toString());
			 }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			odao.close();
		}

		return ls;
	}
	
	//Fetch Order by id
	public void fetchOrderId(){
		OrderDaoImpl odao = new OrderDaoImpl();
		try{
			odao.open();
			
			Orders order=odao.fetchOrderId(29);
			System.out.println(order);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			odao.close();
		}
	
		
	}*/
	

	public static void main(String[] args) {

		Main obj = new Main();
		
		MenuService menuService=new MenuServiceImpl();
		LoginService loginservice=new LoginServiceImpl();

		List<String> ls=menuService.fetchCategoryByType("Veg");  // fetch by types
		System.out.println(ls);
		
		
		
		

		

		/* List<Items>CategoryList=menuService.fetchCategoryByTypeCateg("Veg", "Simply Veg");//Fetch by Type and Category
		 System.out.println(CategoryList);*/
		 
		 
		 
		 

		/* Items pizza=menuService.findItemById(2); // Find item by id
		 System.out.println(pizza.toString());*/

		
		
	/*	 Customer c=new Customer(5, "Miraj", "sachin@gmail.com", "9890652427", "sachin", "sachin123"); //Insert new Customer
		 Customer cust = loginservice.insertNewCustomer(c);	//Inserting new Customer
		 System.out.println(cust);*/
		
		
		
		
		 
		// Customer c1=loginservice.fetchCustomerByEmail("nilesh@sunbeaminfo.com"); //fetch Customer  by Email
		 
		

		 /*List<Pricing>pizzapricing=menuService.fetchItemsPriceById(1); //fetch prize  by id
		 System.out.println(pizzapricing);*/


		
		
		
		
		//*************Insert new Order**********************
		/*LoginService loginservice = new LoginServiceImpl();	
        OrderService orderservice = new OrderServiceImpl();

		Orders order = new Orders();
		Customer cust = new Customer();
		Date date = new Date();
		Pricing price = new Pricing();

		OrderDetails orderdetails = new OrderDetails();

		cust = loginservice.fetchCustomerByEmail("nilesh@sunbeaminfo.com");
        order.setCustomer(cust);
		order.setOrderTime(date);
        order.setStatus("Pending");

		orderdetails.setOrders(order);

		List<OrderDetails> ls = new ArrayList<>();
        ls.add(orderdetails);
        order.setOrderDetailsList(ls);

		orderdetails.setPricing(price);

		Orders order1 = new Orders();
		order1 = orderservice.insertOrder(order);
		System.out.println(order1);
	*///*******************************************************************
		
		
		
	/*	Orders order= new Orders();
		order=orderservice.fetchOrderId(29);		//fetch order by id
		System.out.println(order);*/

		
	/*	String status="Pending";			//Fetch orders (in descending order of time) of given status
		orderservice.fetchOrderStatus(status);*/
				
		


	}
}