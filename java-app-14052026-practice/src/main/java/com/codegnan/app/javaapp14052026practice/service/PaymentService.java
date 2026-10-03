package com.codegnan.app.javaapp14052026practice.service;

public class PaymentService {
	
	//DEPENDENCIES
	CustomerService  customerservice = CustomerService.getInstance();
	OrderService orderservice = new OrderService();
	SellerService SellerService = new SellerService();
	
	
	
	public PaymentService() {
		System.out.println("PaymentService()");
	}
	
	
	
	public void Operation1() {
		System.out.println("Operation 1 from PaymentService");
		
		customerservice.Operation1();
		orderservice.Operation1();
		SellerService.Operation1();
		
	}
	
	public void Operation2() {
		System.out.println("Operation 2 from PaymentService");
	}

}
