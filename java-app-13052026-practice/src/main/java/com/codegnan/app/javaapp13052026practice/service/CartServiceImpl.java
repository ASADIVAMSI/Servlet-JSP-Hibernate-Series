package com.codegnan.app.javaapp13052026practice.service;

import com.codegnan.app.javaapp13052026practice.dao.CartDao;
import com.codegnan.app.javaapp13052026practice.dao.CartDaoImpl;
import com.codegnan.app.javaapp13052026practice.entity.Cart;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public boolean createCart(Cart cart) {
		return cartDao.saveCart(cart);
	}
	
	@Override
	public Cart retrieveCart(int cartId) {
		return cartDao.getCart(cartId);
	}
}