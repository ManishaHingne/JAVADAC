package com.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Pricing;
import com.app.service.LoginService;
import com.app.service.LoginServiceImpl;
import com.app.service.OrderService;
import com.app.service.OrderServiceImpl;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderservice;

	@RequestMapping("/buy")
	public String orderConfirm(HttpSession session, Model map) {

		System.out.println("Inside buy");
		Pricing price = new Pricing();
		Orders order = new Orders();
		Date date = new Date();
		Customer cust = (Customer) session.getAttribute("customer");

		order.setCustomer(cust);
		order.setOrderTime(date);
		order.setStatus("Pending");
		Orders o1 = orderservice.insertOrder(order);
		System.out.println(order);

		OrderDetails od = new OrderDetails();

		List<Pricing> list = (List<Pricing>) session.getAttribute("cart_items");

		for (Pricing pricing : list) {

			map.addAttribute("cmsg", "Order placed with order Id" + o1.getId());
			od.setPricing(pricing);
			od.setOrders(order);
			orderservice.placeOrder(od);

		}

		session.removeAttribute("cart_items");
		session.removeAttribute("total_ammount");
		session.removeAttribute("cart_total");

		return "Purchase";

	}

	@RequestMapping("/admin")
	public String adminView(Model map, @RequestParam(required = false, value = "status") String status) {

		List<Orders> list = null;
		if (status == null) {
			list = orderservice.fetchOrders();
		} else if (status.equals("Dispatched")) {
			list = orderservice.getDispatchedOrders();
		} else if (status.equals("All")) {
			list = orderservice.fetchAllOrders();
		}

		map.addAttribute("Alldetails", list);

		return "AdminPanel";
	}

	@RequestMapping("/orderdetails")
	public String viewOrders(Model map, @RequestParam(required = true, value = "id") String custId) {

		int orderid = Integer.parseInt(custId);
		Orders o = new Orders();
		o.setId(orderid);
		System.out.println("orderid" + orderid);
		Orders od = orderservice.fetchOrdersById(orderid);

		List<OrderDetails> ls = orderservice.fetchOrderDetailsById(o);

		for (OrderDetails o1 : ls) {
			System.out.println(o1.getPricing().getItems().getName());
			System.out.println(o1.getPricing().getSizes());

			System.out.println(o1);
		}

		Customer c = new Customer();

		c.setId(od.getCustomer().getId());
		c.setName(od.getCustomer().getName());
		c.setMobile(od.getCustomer().getMobile());
		c.setAddress(od.getCustomer().getAddress());
		map.addAttribute("cust", c);
		map.addAttribute("custOrders", ls);
		map.addAttribute("status", "pending");
		return "OrderDetails";
	}

	@RequestMapping(value = "/dispatch", method = RequestMethod.GET)
	public String dispatchOrders(Model map, @RequestParam(value = "oid") String oid) {
	

		int orderId = Integer.parseInt(oid);
		orderservice.dispatchordrs(orderId);
		
		
		return "AdminPanel";
	}

}
