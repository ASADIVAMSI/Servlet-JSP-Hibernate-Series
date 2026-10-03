package com.codegnan.app.javaapp15052026practice.service;

public class OrderService implements EcommerceService {

	CustomerService customerService;
	ProductService productService;

	protected OrderService(CustomerService customerService, ProductService productService) {
		System.out.println("OrderService(CustomerService ,ProductService)");

		this.customerService = customerService;
		this.productService = productService;

	}
	
	

	protected OrderService() {
		System.out.println("OrderService()");
	}
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	public void operation1() {
		System.out.println("Operation 1 from OrderService");

		customerService.operation1();
		productService.operation1();

	}

	public void operation2() {
		System.out.println("Operation 2 from OrderService");

		customerService.operation2();
	}

}
