package com.codegnan.app.javaapp14052026practice.service;

public class ProductService {
	
	private static ProductService productservice = new ProductService();
	 
	private ProductService() {
		System.out.println("ProductService()");
	}
	
	public static ProductService getInstance() {
		return productservice;
	}
	
	public void Operation1() {
		System.out.println("Operation 1 from ProductService");
	}
	
	public void Operation2() {
		System.out.println("Operation 2 from ProductService");
	}

}
