package com.codegnan.app.javaapp13052026practice.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@Column(name = "total")
	private double total;
	@OneToMany(mappedBy = "cart")
	private Set<Item> items;

	public Cart() {
	}

	public Cart(int cartId, double total, Set<Item> items) {
		this.cartId = cartId;
		this.total = total;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public double getTotal() {
		return total;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", total=" + total + ", items=" + items + "]";
	}
}