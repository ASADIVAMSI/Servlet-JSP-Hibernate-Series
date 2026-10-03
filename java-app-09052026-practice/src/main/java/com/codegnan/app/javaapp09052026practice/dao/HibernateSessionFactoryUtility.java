package com.codegnan.app.javaapp09052026practice.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.app.javaapp09052026practice.entity.Employee;

public class HibernateSessionFactoryUtility {
	
	public static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().build())
											.addAnnotatedClasses(Employee.class)
											.buildMetadata()
											.buildSessionFactory();
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
