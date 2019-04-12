package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_Customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CustomerId")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Password")
	private String password;

	@Column(name = "Address")
	private String address;

	@Column(name = "Email")
	private String email;

	@Column(name = "Mobile")
	private String mobile;

	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Orders> orderList;

	public Customer(int id, String name, String password, String address, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + "]";
	}

	
}
