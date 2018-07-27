package com.scp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Session session = null;
	private static SessionFactory sf;
	private static Transaction tx;

	public static Session getsession() {
		if (sf == null) {

			sf = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			return session;
		}
		session = sf.openSession();
		tx = session.beginTransaction();
		return session;

	}

	public static void trnsactionRollback() {
		tx.rollback();
	}

	public static void closeSession() {
		if (session != null)
			session.close();
	}

	public static void Flush_Commit(Session sess) {
		if (sess != null) {
			sess.flush();

		}
		if (tx != null) {
			tx.commit();
		}
	}
}
