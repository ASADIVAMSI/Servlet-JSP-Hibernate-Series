package com.codegnan.app.javaapp12052026.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.app.javaapp12052026.entity.Citizen;
import com.codegnan.app.javaapp12052026.entity.Passport;

public class HibernateUtility {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().build())
											.addAnnotatedClasses(Citizen.class,Passport.class)
											.buildMetadata()
											.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}