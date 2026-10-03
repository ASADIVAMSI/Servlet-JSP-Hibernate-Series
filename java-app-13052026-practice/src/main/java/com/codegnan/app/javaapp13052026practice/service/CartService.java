package com.codegnan.app.javaapp13052026practice.service;

import com.codegnan.app.javaapp13052026practice.entity.Cart;

public interface CartService {
	boolean createCart(Cart cart);

	Cart retrieveCart(int cartId);
}