package com.codegnan.app.javaapp15052026practice.service;

public class PaymentService implements EcommerceService{
	
	CustomerService  customerService;
	OrderService orderSrvice;
	SellerService sellerService;
	
	
	
	protected PaymentService(CustomerService  customerService,SellerService sellerService,OrderService orderSrvice) {
		System.out.println("PaymentService(CustomerService,OrderService,SellerService)");
		
		this.customerService = customerService;
		this.orderSrvice = orderSrvice;
		this.sellerService = sellerService;
	}
	
	protected PaymentService() {
		System.out.println("PaymentService()");
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public void setOrderSrvice(OrderService orderSrvice) {
		this.orderSrvice = orderSrvice;
	}
	
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	
	
	public void operation1() {
		System.out.println("Operation 1 from PaymentService");
		
		customerService.operation1();
		orderSrvice.operation1();
		sellerService.operation1();
		
	}
	
	public void operation2() {
		System.out.println("Operation 2 from PaymentService");
	}

}
