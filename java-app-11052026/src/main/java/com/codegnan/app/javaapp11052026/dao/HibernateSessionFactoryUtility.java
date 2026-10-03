package com.codegnan.app.javaapp11052026.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.app.javaapp11052026.entity.Employee;

public class HibernateSessionFactoryUtility {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().build())
											.addAnnotatedClasses(Employee.class)
											.buildMetadata()
											.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}