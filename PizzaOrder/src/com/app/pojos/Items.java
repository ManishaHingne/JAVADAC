package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_ITEMS")
public class Items {

	@Id
	@GeneratedValue
	@Column(name = "ItemsId")
	private int id;

	@Column(name = "Description")
	private String description;

	@Column(name = "Name")
	private String name;

	@Column(name = "Type")
	private String type;

	@Column(name = "Category")
	private String Category;

	@OneToMany(mappedBy = "items")
	private List<Pricing> pricingList;

	public Items(int id, String description, String name, String type, String category, List<Pricing> pricingList) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.type = type;
		Category = category;
		this.pricingList = pricingList;
	}

	public Items() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public List<Pricing> getPricingList() {
		return pricingList;
	}

	public void setPricingList(List<Pricing> pricingList) {
		this.pricingList = pricingList;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", description=" + description + ", name=" + name + ", type=" + type + ", Category="
				+ Category + "]";
	}

	

}
