package com.app.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;

public interface OrderDao {

	// String registerOrder(Orders o);

	// List<Orders> getOrder(int orderId);

	void open();

	void close();

	Orders insertOrder(Orders order);

	List<Orders> fetchOrderStatus(String status);

	Orders fetchOrdersById(int id);

	Integer placeOrder(OrderDetails od);

	List<Orders> fetchOrders();

	List<Orders> getDispatchedOrders();

    List<Orders> fetchAllOrders();
    
    List<OrderDetails> fetchOrderDetailsById(Orders id);
    
    Orders fetchOrderById(Customer id);
    
    int dispatchordrs(int id);

}
