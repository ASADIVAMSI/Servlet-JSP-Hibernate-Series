package com.codegnan.app.javaapp15052026practice.service;

public class ProductService implements EcommerceService{
	
	SellerService sellerService;
	
	protected ProductService(SellerService sellerService) {
		System.out.println("ProductService(SellerService)");
		
		this.sellerService=sellerService;
	}
	protected ProductService() {
		System.out.println("ProductService()");
	}
	
	public void setSellerService(SellerService sellerService) {
		System.out.println("ProductService():setSellerService()");
		
		this.sellerService = sellerService;
	}
	
	public void operation1() {
		System.out.println("Operation 1 from ProductService");
	}
	
	public void operation2() {
		System.out.println("Operation 2 from ProductService");
	}

}
