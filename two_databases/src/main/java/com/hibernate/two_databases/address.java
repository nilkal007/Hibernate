package com.hibernate.two_databases;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class address {
	@Id
	int id;
	String Address;

	public address(int id, String address) {
		super();
		this.id = id;
		Address = address;
	}
	public address() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "address [id=" + id + ", Address=" + Address + "]";
	}

}
