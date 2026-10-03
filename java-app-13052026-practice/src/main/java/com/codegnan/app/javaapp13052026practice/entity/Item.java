package com.codegnan.app.javaapp13052026practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Item {
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	public Item() {
	}

	public Item(int itemId, double price, int quantity, Cart cart) {
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
	}

	public int getItemId() {
		return itemId;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", price=" + price + ", quantity=" + quantity + ", cart=" + cart + "]";
	}
}