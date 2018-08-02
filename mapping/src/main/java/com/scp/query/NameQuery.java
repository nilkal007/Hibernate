package com.scp.query;

import org.hibernate.Session;

import com.scp.mapping.HibernateUtil;

public class NameQuery {

	public static void main(String[] args) {
		
		
		  Product p1=new Product(1, "samsung", 50000.0, "mobile");
		  Product p2=new Product(2, "lg", 52000.0, "ac");
		  Product p3=new Product(3, "ps", 14000.0, "tv");
		  Product p4=new Product(4, "wp", 15000.0, "wm");
		  Product p5=new Product(5, "samsung", 20000.0, "laptop");
		  Product p6=new Product(6, "apple", 62000.0, "mobile");
		  Product p7=new Product(7, "acer", 74000.0, "laptop");
		  Product p8=new Product(8, "wp", 58000.0, "ac");
		  
		  Session session=HibernateUtil.getSeesion(); session.save(p1);
		  session.save(p2); session.save(p3); session.save(p4);
		  session.save(p5);
		  session.save(p6); session.save(p7); session.save(p8);
		  HibernateUtil.commit_flush();
		 
		//Session session = HibernateUtil.getSeesion();
		/*
		 * Product p1=session.get(Product.class, 1); System.out.println(p1); Product
		 * p2=session.load(Product.class, 2);//lezy p2.getCategory();
		 * System.out.println(p2);
		 */
		/*
		 * System.out.println("Using HQL--Entity--Fields"); List<Product>
		 * p3=session.createQuery("from Product").list(); System.out.println(p3);
		 * 
		 * System.out.println("Using SQL--Table--columns"); List<Product> p4=
		 * session.createSQLQuery("select * from Product").addEntity(Product.class).list
		 * (); System.out.println(p4);
		 * 
		 * List<Product> p5=session.getNamedQuery("HQL_GET_ALL_PRODUCT").list();
		 * System.out.println(p5);
		 */
		
		   /*Query q1=session.getNamedQuery("HQL_GET_PRICE_GREATER_THAN");
		   q1.setParameter("price", 50000.0); List<Product> p1=q1.getResultList();
		   System.out.println(p1);
		   
		   Query q2=session.getNamedQuery("HQL_GET_PRICE_GREATER_THAN_AND _NAME");
		   q2.setParameter(1, 100000.0); q2.setParameter(2, "samsung"); List<Product>
		   p2=q2.getResultList(); System.out.println(p2);*/
		 

		/*List<Product> p3 = session.getNamedNativeQuery("SQL_GET_PRICE_GREATER_THAN").setParameter("price", 50000.0)
				.addEntity(Product.class).list();
		System.out.println(p3);

		List<Product> p4 = session.getNamedNativeQuery("SQL_GET_PRICE_GREATER_THAN_AND _NAME").setParameter(1, 50000.0)
				.setParameter(2, "samsung").addEntity(Product.class).list();
		List<Product> p5 = session.getNamedNativeQuery("SQL_GET_NAME").setParameter("name", "samsung")
				.addEntity(Product.class).list();
		System.out.println(p5);*/

	}

}
