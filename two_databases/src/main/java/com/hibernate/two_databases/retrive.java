package com.hibernate.two_databases;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;



import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.Enumerator;


public class retrive {
	public static void main(String[] args) {
		int count =0;
		SessionFactory sf= new Configuration().configure("retrives.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx =session.beginTransaction();
		List<student> students = session.createQuery("from student").getResultList();
		for (student student : students) {
			//session.save(new address(student.id, student.name));
			System.out.println(student.id+"  "+student.name);
		}
		
		session.flush();
		tx.commit();
		
		
		SessionFactory sf2= new Configuration().configure("retrivea.cfg.xml").buildSessionFactory();
		Session session2 = sf2.openSession();
		Transaction tx2 =session2.beginTransaction();
		List<address> address1= session2.createQuery("from address").getResultList();
		
		for (address addressa : address1) {
			System.out.println(addressa.id+" "+addressa.Address);
		}
		
		session2.flush();
		tx2.commit();
		//Map<student, address> aMap = new WeakHashMap<>();
		
		
		SessionFactory sf3= new Configuration().configure("newtable.cfg.xml").buildSessionFactory();
		Session session3 = sf3.openSession();
		Transaction tx3 =session3.beginTransaction();
		for (student student : students) {
			for (address addressa : address1) {
				if(addressa.id==student.id )					
				session3.save(new newtable(student.getId(), student.getName(), addressa.getAddress()));
			//	System.out.println(student.id+" "+student.name+" "+addressa.Address);
				
			}
			
		}
		/* Set<Entry<student, address>>  enum1=  aMap.entrySet();
			
			Iterator<Entry<student, address>> mobemp = enum1.iterator();
			while (mobemp.hasNext()) {
				session3.save(mobemp);
				Entry<student, address> entry = mobemp.next();
				System.out.println(entry.getKey() + "............." + entry.getValue());
			}*/
		session3.flush();
		tx3.commit();
		 
		
		
		
						
		
	}
}

	
