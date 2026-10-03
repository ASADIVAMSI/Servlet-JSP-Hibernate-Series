package com.codegnan.app.javaapp14052026practice.service;

public class OrderService {
	//DEPENDENCIES
	//CustomerService  customerservice ;
	CustomerService  customerservice =CustomerService.getInstance();
	
	ProductService productservice = ProductService.getInstance();
	
	public OrderService() {
		System.out.println("OrderService()");
	
	}
	
	public void Operation1() {
		System.out.println("Operation 1 from OrderService");
		
		customerservice.Operation1();
		
		productservice.Operation1();
		
	}
	
	public void Operation2() {
		System.out.println("Operation 2 from OrderService");
		
		customerservice.Operation2();
	}

}
