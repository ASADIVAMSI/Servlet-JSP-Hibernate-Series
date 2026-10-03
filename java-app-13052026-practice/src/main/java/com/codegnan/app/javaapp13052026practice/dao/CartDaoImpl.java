package com.codegnan.app.javaapp13052026practice.dao;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.codegnan.app.javaapp13052026practice.entity.Cart;
import com.codegnan.app.javaapp13052026practice.entity.Item;

public class CartDaoImpl implements CartDao {
	@Override
	public boolean saveCart(Cart cart) {
		boolean isSaved = false;

		SessionFactory sessionFactory = DatabaseUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(cart);
		
		Set<Item> cartItems = cart.getItems();
		for (Item item : cartItems) {
			session.persist(item);
		}

		transaction.commit();
		session.close();
		isSaved = true;

		return isSaved;
	}
	
	@Override
	public Cart getCart(int cartId) {
		Cart cart = null;
		
		SessionFactory sessionFactory = DatabaseUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Cart cartInSession = session.get(Cart.class, cartId);
		if (cartInSession != null) {
			cart = new Cart();
			cart.setCartId(cartInSession.getCartId());
			cart.setTotal(cartInSession.getTotal());
			cart.setItems(cartInSession.getItems());
		}

		return cart;
	}
}