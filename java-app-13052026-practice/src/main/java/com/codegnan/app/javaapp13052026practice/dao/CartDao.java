package com.codegnan.app.javaapp13052026practice.dao;

import com.codegnan.app.javaapp13052026practice.entity.Cart;

public interface CartDao {
	boolean saveCart(Cart cart);

	Cart getCart(int cartId);
}