package com.app.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.utils.HbUtil;

public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sf;
	private Session session;
	private Transaction tx;

	public void open() {
		session = HbUtil.getSessionFactory().openSession();

	}

	public void close() {

		session.close();
	}

	@Override
	public List<Orders> fetchOrderStatus(String status) {

		Query query = session
				.createQuery("SELECT order FROM Orders order where STATUS=:status order by OrderTime desc ")
				.setParameter("status", status);

		return query.list();

	}

	@Override
	public Orders insertOrder(Orders order) {
		session.beginTransaction();

		session.save(order);

		session.getTransaction().commit();

		return order;

	}

	@Override
	public Integer placeOrder(OrderDetails od) {
		Transaction tx = session.beginTransaction();

		Integer id = (Integer) session.save(od);

		tx.commit();

		return id;

	}

	@Override
	public Orders fetchOrdersById(int id) {

		Orders obj = (Orders) session.get(Orders.class, id);
		return obj;

	}

	@Override
	public Orders fetchOrderById(Customer cust) {

		Query query = session.createQuery("from Orders o where CustomerId=:id").setParameter("id", cust.getId());
		Orders o = (Orders) query.uniqueResult();
		
		System.out.println(o);
		return o;
	}

	@Override
	public List<Orders> fetchOrders() {

		return session.createQuery("SELECT o FROM Orders o where o.status='Pending'").list();
	}

	@Override
	public List<Orders> getDispatchedOrders() {

		return session.createQuery("SELECT o FROM Orders o where o.status='Dispatched'").list();

	}

	@Override
	public List<Orders> fetchAllOrders() {
		return session.createQuery("SELECT o FROM Orders o").list();

	}

	@Override
	public List<OrderDetails> fetchOrderDetailsById(Orders id) {
		Query query = session.createQuery("SELECT ord from OrderDetails ord where orders=:id").setParameter("id", id);
		List<OrderDetails> ls = query.list();

		return ls;
	}

	public int dispatchordrs(int oid)
	{
		
		Transaction tx = session.beginTransaction();
		Query query =session.createQuery("update Orders o set o.status='Dispatched' where id=:id").setParameter("id", oid);
		int orderId =query.executeUpdate();
		tx.commit();
		return orderId;
	}

}
