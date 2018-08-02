package com.scp.query;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "HQL_GET_ALL_PRODUCT", query = "from Product"),
		@NamedQuery(name = "HQL_GET_PRICE_GREATER_THAN", query = "from Product where price >=:price"),
		@NamedQuery(name = "HQL_GET_PRICE_GREATER_THAN_AND _NAME", query = "from Product where price>=?1 and name=?2") })
@NamedNativeQueries({ @NamedNativeQuery(name = "SQL_GET_ALL_PRODUCT", query = "select * from Product"),
		@NamedNativeQuery(name = "SQL_GET_PRICE_GREATER_THAN", query = "select * from Product where price >=:price"),
		@NamedNativeQuery(name = "SQL_GET_NAME", query = "select * from Product where name=:name"),
		@NamedNativeQuery(name = "SQL_GET_PRICE_GREATER_THAN_AND _NAME", query = " select * from Product where price>=?1 and name=?2") })
public class Product {
	@Id
	private int id;
	private String name;
	private Double price;
	private String category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, Double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "\nProduct [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}

}



