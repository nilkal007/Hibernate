package com.scp.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

public class OneToManyUni {

	public static void main(String[] args) {
		Student3 s1 = new Student3(1, "nilesh", null);
		Student3 s2 = new Student3(2, "prasad", null);
		
		Address3 a1 = new Address3(20, "bmc", "pune",null);
		Address3 a2 = new Address3(30, "peth", "mumbai",null);
		Address3 a3 = new Address3(40, "karve nagar", "nashik",null);
		Address3 a4 = new Address3(50, "kothrud", "aurangabad",null);
		
		List<Address3> list1 = new ArrayList<Address3>();
		list1.add(a1);
		list1.add(a2);
		
		List<Address3> list2 = new ArrayList<Address3>();
		list2.add(a3);
		list2.add(a4);
		
        s1.setAddress3(list1);
		s2.setAddress3(list2);
		a1.setStudent3(s1);
	
		a2.setStudent3(s2);
		a3.setStudent3(s1);
		a4.setStudent3(s2);

		Session session = HibernateUtil.getSeesion();
		session.save(s1);
		session.save(s2);

		HibernateUtil.commit_flush();

	}

}

@Entity
@Table
class Student3 {
	@Id
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address3> address3;

	public Student3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student3(int id, String name, List<Address3> address3) {
		super();
		this.id = id;
		this.name = name;
		this.address3 = address3;
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

	public List<Address3> getAddress3() {
		return address3;
	}

	public void setAddress3(List<Address3> address3) {
		this.address3 = address3;
	}

	@Override
	public String toString() {
		return "Student3 [id=" + id + ", name=" + name + ", address3=" + address3 + "]";
	}

	
}

@Entity
@Table
class Address3 {
	@Id
	private int addId;
	private String street;
	private String city;
	@ManyToOne
	private Student3 student3;

	public Address3() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address3(int addId, String street, String city, Student3 student3) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.student3 = student3;
	}


	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student3 getStudent3() {
		return student3;
	}

	public void setStudent3(Student3 student3) {
		this.student3 = student3;
	}

	@Override
	public String toString() {
		return "Address3 [addId=" + addId + ", street=" + street + ", city=" + city + ", student3=" + student3 + "]";
	}

	

}