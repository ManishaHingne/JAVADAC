package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_Pricing")
public class Pricing {

	@Id
	@GeneratedValue
	@Column(name = "PriceId")
	private int id;

	@Column(name = "Sizes")
	private String sizes;

	@Column(name = "Price")
	private Double price;

	@ManyToOne
	@JoinColumn(name = "ItemsId")
	private Items items;

	@OneToMany(mappedBy = "pricing")
	private List<OrderDetails> orderdetails;

	public Pricing(int id, String sizes, Double price) {
		super();
		this.id = id;
		this.sizes = sizes;
		this.price = price;
	}

	
	
	
	public Pricing() {
		super();
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}




	@Override
	public String toString() {
		return "Pricing [id=" + id + ", sizes=" + sizes + ", price=" + price + ", items=" + items + "]";
	}




	
	

}
