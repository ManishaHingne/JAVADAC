package com.app.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderDao;
import com.app.dao.OrderDaoImpl;
import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.utils.HbUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private SessionFactory sf;

	private Session session;
	private Transaction tx;

	OrderDao dao = new OrderDaoImpl();

	@Override
	public Orders insertOrder(Orders order) {
		dao.open();

		Orders orders = new Orders();
		orders = dao.insertOrder(order);
		dao.close();
		return orders;

	}

	@Override
	public List<Orders> fetchOrderStatus(String status) {
		dao.open();
		List<Orders> ls = dao.fetchOrderStatus(status);
		dao.close();
		return ls;

	}

	@Override
	public Orders fetchOrdersById(int id) {
		dao.open();
		Orders orders = new Orders();
		orders = dao.fetchOrdersById(id);

		dao.close();
		return orders;
	}

	public Integer placeOrder(OrderDetails od) {

		dao.open();

		Integer id = dao.placeOrder(od);
		dao.close();
		return id;
	}

	@Override
	public List<Orders> fetchOrders() {
		dao.open();

		List<Orders> ls = dao.fetchOrders();
		dao.close();
		return ls;
	}

	@Override
	public List<Orders> getDispatchedOrders() {
		dao.open();

		List<Orders> ls = dao.getDispatchedOrders();
		dao.close();
		return ls;
	}

	@Override
	public List<Orders> fetchAllOrders() {
		dao.open();
		List<Orders> ls = dao.fetchAllOrders();
		dao.close();
		return ls;
	}

	@Override
	public List<OrderDetails> fetchOrderDetailsById(Orders id) {

		dao.open();
		List<OrderDetails> od = dao.fetchOrderDetailsById(id);
		dao.close();
		System.out.println(od);
		return od;

	}

	@Override
	public Orders fetchOrderById(Customer cust) {

		dao.open();

		Orders obj = (Orders) dao.fetchOrderById(cust);
		dao.close();
		return (Orders) obj;

	}

	@Override
	public int dispatchordrs(int oid) {
		dao.open();
		int orderid = dao.dispatchordrs(oid);
		dao.close();
		return oid;
	}

}
