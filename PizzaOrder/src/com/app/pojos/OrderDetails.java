package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue
	@Column(name = "OrderDetails_ID")
	private int id;

	// @Column(name = "OrderDetailsId")
	// private int orderid;

	// @Column(name = "PriceID")
	// private int priceid;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "OrderId")
	private Orders orders;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "PriceId")
	private Pricing pricing;

	
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int id, Orders orders, Pricing pricing) {
		super();
		this.id = id;
		this.orders = orders;
		this.pricing = pricing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Pricing getPricing() {
		return pricing;
	}

	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orders=" + orders + ", pricing=" + pricing + "]";
	}

}
