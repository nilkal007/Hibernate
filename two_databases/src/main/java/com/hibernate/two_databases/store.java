package com.hibernate.two_databases;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class store {

	public static void main(String[] args) {
		student s1=new student(1, "nilesh");
		student s2=new student(2, "prasad");
		student s3=new student(3, "akash");
		student s4=new student(4, "akash");
		address a1=new address(1, "mumbai");
		address a2=new address(2, "pune");
		address a3=new address(3, "satara");
		address a4=new address(4, "bara");
		
		SessionFactory  sf=new Configuration().configure("student.cfg.xml").buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(s1);
		ss.save(s2);
		ss.save(s3);
		ss.save(s4);
		ss.flush();
		tx.commit();
		SessionFactory  sf1=new Configuration().configure("address.cfg.xml").buildSessionFactory();
		Session ss1=sf1.openSession();
		Transaction tx1=ss1.beginTransaction();
		ss1.save(a1);
		ss1.save(a2);
		ss1.save(a3);
		ss1.save(a4);
		ss1.flush();
		tx1.commit();
		
		
		
		
	}

}
