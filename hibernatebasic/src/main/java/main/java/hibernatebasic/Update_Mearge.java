package main.java.hibernatebasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Update_Mearge {

	public static void main(String[] args) {
		Book b1=new Book(10, "nilesh", 5000);
		Session sessionFactory=HibernateUtil.getsession();
		Session session1 =HibernateUtil.getsession();
		Transaction tx =session1.beginTransaction();
		//session1.save(b1);
		
		HibernateUtil.flush_commit(session1, tx);
		
		session1.evict(b1);//detached
		session1.close();
		b1.setBk_nm("mint-1");
		session1.close();
		Session session2=HibernateUtil.getsession();
		Transaction tx2=session2.beginTransaction();
		//Book b2=session2.get(Book.class, 2);//return -java.lang.NullPointerException -if object is not there 
		Book b2=session2.load(Book.class, 10);//org.hibernate.ObjectNotFoundException-if object is not there
		System.out.println(b2);
		b2.setBk_nm("mint");
		//session2.update(b1);// org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [main.java.hibernatebasic.Book#1]
		session2.merge(b1);
		System.out.println("hi");
		HibernateUtil.flush_commit(session2, tx2);
		session2.close();
		
	}

}
