package com.scp.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.scp.mapping.HibernateUtil;
import com.scp.query.Product;

public class TestCriteria {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSeesion();
		Criteria criteria = session.createCriteria(Product.class);
		// criteria.add(Restrictions.eq("category", "laptop"));
		criteria.add(Restrictions.le("price", 50000.0));
		criteria.addOrder(Order.asc("name"));
		List<Product> p1 = criteria.list();
		System.out.println(p1);
		Criteria criteria2 = session.createCriteria(Product.class);
		Criterion c1 = Restrictions.like("name", "s%");
		Criterion c2 = Restrictions.gt("price", 50000.0);
		LogicalExpression orlg = Restrictions.or(c1, c2);
		criteria2.add(orlg);
		List<Product> p2 = criteria2.list();
		System.out.println(p2);
		//pegination
		Criteria criteria3=session.createCriteria(Product.class);
		criteria3.setFirstResult(0);
		criteria3.setMaxResults(5);
		criteria3.addOrder(Order.desc("name"));
		List<Product> plist3=criteria3.list();
		System.out.println(plist3);
		//projection and aggrigation
		Criteria criteria4=session.createCriteria(Product.class);
		criteria4.setProjection(Projections.sum("price"));
		//criteria4.setProjection(Projections.avg("price"));
		//criteria4.setProjection(Projections.min("price"));
		List<Product> pList4=criteria4.list();
		System.out.println(pList4);
		
		
	}

}
