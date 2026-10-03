package com.codegnan.app.javaapp16052026practice.service;

public class SellerService implements EcommerceService{
	
	ProductService productService;
	
	protected SellerService(ProductService productService) {
		System.out.println("SellerService(ProductService)");
		
		this.productService=productService;
	}
	protected SellerService() {
		System.out.println("SellerService()");
	}
	
	public void setProductService(ProductService productService) {
		System.out.println("SellerService():setProductService()");
		
		this.productService = productService;
	}
	
	public void operation1() {
		System.out.println("Operation 1 from SellerService");
	}
	
	public void operation2() {
		System.out.println("Operation 2 from SellerService");
	}

}
