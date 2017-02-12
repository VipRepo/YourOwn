package com.vip.inventory.model;

import java.math.BigInteger;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private BigInteger id;

	private String name;

	private double price;

	private String description;

	List<ProductCatagoryEnum> productCatagories = new ArrayList<ProductCatagoryEnum>();

	/*
	 * public Product(long id, String name, double price, String description,
	 * List<ProductCatagoryEnum> catagories) { super(); this.id = new
	 * BigInteger(id); this.name = name; this.price = price; this.description =
	 * description; this.productCatagories.addAll(catagories); }
	 * 
	 * public Product(double price, String name,String description,
	 * List<ProductCatagoryEnum> catagories) { super(); this.price = price;
	 * this.name = name; this.description = description;
	 * this.productCatagories.addAll(catagories); }
	 */

	public Product clone() {
		return new Product(this.getName(), this.getPrice(), this.getDescription(),
				Arrays.asList(ProductCatagoryEnum.BOOKS));
	}

	public Product(BigInteger id, String name, double price, String description,
			List<ProductCatagoryEnum> productCatagories) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.productCatagories = productCatagories;
	}

	public Product(String name, double price, String description, List<ProductCatagoryEnum> productCatagories) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.productCatagories = productCatagories;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public List<ProductCatagoryEnum> getProductCatagories() {
		return productCatagories;
	}

	public void setProductCatagories(List<ProductCatagoryEnum> productCatagories) {
		this.productCatagories = productCatagories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
