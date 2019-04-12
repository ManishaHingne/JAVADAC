package com.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_Orders")
public class Orders {

	@Id
	@GeneratedValue
	@Column(name = "OrderId")
	private int id;

	@Column(name = "OrderTime")
	private Date orderTime;

	@Column(name = "Status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;

	@OneToMany(mappedBy = "orders",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<OrderDetails> OrderDetailsList;

	
	
	public Orders() {
		super();
	}

	public Orders(int id, Date date, String status) {
		super();
		this.id = id;
		this.orderTime = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderDetailsList() {
		return OrderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		OrderDetailsList = orderDetailsList;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderTime=" + orderTime + ", status=" + status + "]";
	}

	

}
