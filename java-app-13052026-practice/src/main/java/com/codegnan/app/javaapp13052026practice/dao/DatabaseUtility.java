package com.codegnan.app.javaapp13052026practice.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.app.javaapp13052026practice.entity.Cart;
import com.codegnan.app.javaapp13052026practice.entity.Item;

public class DatabaseUtility {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().build())             
                        .addAnnotatedClass(Cart.class)
                        .addAnnotatedClass(Item.class)
                        .buildMetadata()                  
                        .buildSessionFactory();  
		
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}