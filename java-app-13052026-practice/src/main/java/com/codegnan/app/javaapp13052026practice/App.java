package com.codegnan.app.javaapp13052026practice;

import java.util.HashSet;
import java.util.Set;

import com.codegnan.app.javaapp13052026practice.entity.Cart;
import com.codegnan.app.javaapp13052026practice.entity.Item;
import com.codegnan.app.javaapp13052026practice.service.CartService;
import com.codegnan.app.javaapp13052026practice.service.CartServiceImpl;

public class App {
	public static void main(String[] args) {
		CartService cartService = new CartServiceImpl();
		
		/*
		//CREATING ITEMS
		Item item1 = new Item();
		item1.setPrice(25);
		item1.setQuantity(5);
		
		Item item2 = new Item();
		item2.setPrice(70);
		item2.setQuantity(3);
		
		HashSet<Item> items = new HashSet<>();
		items.add(item1);
		items.add(item2);
		
		
		//CALCULATING TOTAL ORDER AMOUNT
		double totalAmount = item1.getPrice() * item1.getQuantity();
		totalAmount += item2.getPrice() * item2.getQuantity();
		
		
		
		//CREATING CART
		Cart cart = new Cart();
		cart.setTotal(totalAmount);		
		cart.setItems(items);//ADDING ITEMS TO CART
		
		//ADDING CART TO ITEMS
		item1.setCart(cart);
		item2.setCart(cart);
		
		boolean isCartCreated = cartService.createCart(cart);
		if (isCartCreated) {
			System.out.println("Cart successfully saved.");
		} else {
			System.out.println("Error saving cart.");
		}
		*/
		
	
		Cart cart = cartService.retrieveCart(100);
		if (cart != null) {
			System.out.println("Cart ID: " + cart.getCartId());
			System.out.println("Total Order Amount: INR " + cart.getTotal());
			System.out.println("Items: ");
			Set<Item> cartItems = cart.getItems();
			for (Item item : cartItems) {
				System.out.println("Item ID: " + item.getItemId());
				System.out.println("Price: " + item.getPrice());
				System.out.println("Quantity: " + item.getQuantity());
				System.out.println("-----");
			}
		} else {
			System.out.println("Invalid Cart ID.");
		}
		
	}
}