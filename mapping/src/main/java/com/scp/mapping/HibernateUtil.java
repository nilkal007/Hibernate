package com.scp.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionfactory = null;
	private static Session session;
	private static Transaction tx;

	public static Session getSeesion() {
		if (sessionfactory == null) {
			sessionfactory = new Configuration().configure().buildSessionFactory();
			session = sessionfactory.openSession();
			tx = session.beginTransaction();
			return session;
		}
		session = sessionfactory.openSession();
		tx = session.beginTransaction();
		return session;
	}

	public static void commit_flush() {
		if (session != null) {
			session.flush();

		}
		if (tx != null) {
			tx.commit();
		}
	}
}
